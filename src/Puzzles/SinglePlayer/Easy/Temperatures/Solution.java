package Puzzles.SinglePlayer.Easy.Temperatures;

import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        in.nextLine();
        String temps = in.nextLine(); // the n temperatures expressed as integers ranging from -273 to 5526

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        String[] tempArray = temps.split(" ");
        String result = tempArray[0];

        for (int i = 0; i < n; i++) {

            int temp = Integer.parseInt(tempArray[i]);

            if (Math.abs(temp) < Math.abs(Integer.parseInt(result))) {
                result = String.valueOf(temp);
            } else if (Math.abs(temp) == Math.abs(Integer.parseInt(result))) {
                result = String.valueOf(Integer.max(temp, Integer.parseInt(result)));
            }
        }

        if (n == 0) {
            result = "0";
        }

        System.out.println(result);
    }
}