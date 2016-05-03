package Puzzles.SinglePlayer.Easy.PowerOfThor;

import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int LX = in.nextInt(); // the X position of the light of power
        int LY = in.nextInt(); // the Y position of the light of power
        int TX = in.nextInt(); // Thor's starting X position
        int TY = in.nextInt(); // Thor's starting Y position

        // game loop
        while (true) {
            int E = in.nextInt(); // The level of Thor's remaining energy, representing the number of moves he can still make.

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            String direction = "";
            if (TY < LY) {
                TY++;
                direction = "S";

            } else if (TY > LY) {
                TY--;
                direction = "N";
            }

            if (TX < LX) {
                TX++;
                direction += "E";
            } else if (TX > LX) {
                TX--;
                direction += "W";
            }

            System.out.println(direction);
            //System.out.println("N");
            //A single line providing the move to be made: N NE E SE S SW W or NW
        }
    }
}