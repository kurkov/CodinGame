package Puzzles.SinglePlayer.Easy.SkynetTheChasm;

import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt(); // the length of the road before the gap.
        int G = in.nextInt(); // the length of the gap.
        int L = in.nextInt(); // the length of the landing platform.

        // game loop
        while (true) {
            int S = in.nextInt(); // the motorbike's speed.
            int X = in.nextInt(); // the position on the road of the motorbike.

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            // A single line containing one of 4 keywords: SPEED, SLOW, JUMP, WAIT.
            if (X == R - 1) {
                System.out.println("JUMP");
            } else if (X > R || S > G + 1) {
                System.out.println("SLOW");
            } else if (S < G + 1) {
                System.out.println("SPEED");
            } else {
                System.out.println("WAIT");
            }

        }
    }
}