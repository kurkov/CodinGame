package Puzzles.SinglePlayer.Medium.ApuInitPhase;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Playe2 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        in.nextLine();
        //ArrayList<String> lineList = new ArrayList<>();
        String[][] lineList = new String[height][width];
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            for (int j = 0; j < line.length(); j++) {
                lineList[i][j] = String.valueOf(line.charAt(j));
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // Three coordinates: a node, its right neighbor, its bottom neighbor
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                if (lineList[y][x].equals("0")) {
                    System.out.print(x + " " + y + " ");
                } else {
                    System.out.print("-1 -1 ");
                }

                if (y + 1 < height) {
                    if (lineList[y + 1][x].equals("0")) {
                        System.out.print((y + 1) + " " + x + " ");
                    } else {
                        System.out.print("-1 -1 ");
                    }
                } else {
                    System.out.print("-1 -1 ");
                }

                if (x + 1 < width) {
                    if (lineList[y][x + 1].equals("0")) {
                        System.out.print(y + " " + (x + 1) + " ");
                    } else {
                        System.out.print("-1 -1 ");
                    }
                } else {
                    System.out.print("-1 -1 ");
                }
                System.out.println();
            }
        }
    }
}