package Puzzles.SinglePlayer.Easy.HorseRasingDuals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Integer> horses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            horses.add(in.nextInt());
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        Collections.sort(horses);
        int diff, minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < horses.size(); i++) {
            diff = horses.get(i) - horses.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        System.out.println(minDiff);
    }
}