package Puzzles.SinglePlayer.Medium.MarsLanderLevel2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    private static int plainMinX, plainMaxX, plainCenter;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.
        List<Point> surfaceCoords = new ArrayList<>(surfaceN);
        for (int i = 0; i < surfaceN; i++) {
            int landX = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int landY = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            surfaceCoords.add(new Point(landX, landY));
        }

        // Find plain surface coordinates
        fingPlaneSurface(surfaceCoords);
        plainCenter = (plainMinX + plainMaxX) / 2;

        // game loop
        while (true) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int hSpeed = in.nextInt(); // the horizontal speed (in m/s), can be negative.
            int vSpeed = in.nextInt(); // the vertical speed (in m/s), can be negative.
            int fuel = in.nextInt(); // the quantity of remaining fuel in liters.
            int rotate = in.nextInt(); // the rotation angle in degrees (-90 to 90).
            int power = in.nextInt(); // the thrust power (0 to 4).

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            System.err.println("min: " + plainMinX + " max: " + plainMaxX);
            int pow = 0;

            if (Math.abs(hSpeed) < 70 && Y < 2200) {
                if (Y < 200) {
                    action(0, 4);
                } else {
                    if (plainMinX < X) {
                        action(20, 4);
                    } else {
                        action(-20, 4);
                    }
                }
            }
            else {
                if (Math.abs(rotate) < 40) {
                    pow = 0;
                } else {
                    pow = 4;
                }
                int direction = hSpeed > 0 ? -1 : 1;

                if (plainMinX < X) {
                    action(50 * direction, pow);
                } else {
                    action(-50 * direction, pow);
                }
            }

            /*if (X - plainCenter < 0) {
                if (angle )
                angle = angle * -1;
            }*/

            /*if (X < plainCenter) {
                if (X < plainCenter - 1200) {
                    if (X > plainCenter - 500) {
                        if (Y > 300) {
                            System.out.println("22 4");
                        } else {
                            System.out.println("0 4");
                        }
                    } else {
                        if (Y > 300) {
                            System.out.println("-22 3");
                        } else {
                            System.out.println("0 4");
                        }
                    }
                } else {
                    if (Y > 700) {
                        System.out.println("22 4");
                    } else {
                        System.out.println("0 4");
                    }
                }
            } else if (X > plainCenter) {
                System.out.println("22 3");
            }*/

            // rotate power. rotate is the desired rotation angle. power is the desired thrust power.
            /*if (X < 3500) {
                System.out.println("-25 3");
            } else {
                if (Y > 700) {
                    System.out.println("20 4");
                } else {
                    System.out.println("0 4");
                }
            }*/


        }
    }

    private static void fingPlaneSurface(List<Point> surfaceCoords) {
        boolean isFoundPlainMinX = false, isFoundPlainMaxX = false;
        for (int i = 0; i < surfaceCoords.size(); i++) {
            if (i + 1 != surfaceCoords.size()) {
                if (surfaceCoords.get(i).y == surfaceCoords.get(i + 1).y && !isFoundPlainMinX) {
                    isFoundPlainMinX = true;
                    plainMinX = surfaceCoords.get(i).x;
                }
                if (isFoundPlainMinX && !isFoundPlainMaxX && surfaceCoords.get(i).y != surfaceCoords.get(i + 1).y) {
                    isFoundPlainMaxX = true;
                    plainMaxX = surfaceCoords.get(i).x;
                }
            }
        }
    }

    private static void action(int angle, int power) {
        System.out.println(angle + " " + power);
    }

    private static class Point {

        final int x;
        final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private static long point(int x, int y) {
            return (((long) x) << 32) | y;
        }

        private static int x(long point) {
            return (int) (point >> 32);
        }

        private static int y(long point) {
            return (int) point;
        }
    }
}