package Puzzles.SinglePlayer.Easy.AsciiArt;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ?";

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine().toUpperCase();
        ArrayList<String> ascii = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            ascii.add(ROW);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        ArrayList<Integer> indexes = getIndexes(T);
        printResult(L, H, ascii, indexes);
    }

    private static void printResult(int width, int height, ArrayList<String> ascii, ArrayList<Integer> indexes) {
        for (int j = 0; j < height; j++) {
            for (int k = 0; k < indexes.size(); k++) {
                System.out.print(ascii.get(j).substring(indexes.get(k) * width, indexes.get(k) * width + width));
            }
            System.out.println();
        }
    }

    private static ArrayList<Integer> getIndexes(String t) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (char c : t.toCharArray()) {
            if (c < 'A' || c > 'Z') {
                // return char '?'
                indexes.add(26);
            } else {
                for (char letter : alphabet.toCharArray()) {
                    if (c == letter) {
                        indexes.add(alphabet.indexOf(letter));
                    }
                }
            }
        }
        return indexes;
    }
}