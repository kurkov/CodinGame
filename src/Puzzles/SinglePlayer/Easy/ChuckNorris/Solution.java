package Puzzles.SinglePlayer.Easy.ChuckNorris;

import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        String result = get7bitBinaryString(MESSAGE);
        getChuckNorrisEncoding(result);
    }

    private static String get7bitBinaryString(String MESSAGE) {
        StringBuilder binaryChar7bit = new StringBuilder();
        String binaryChar;
        for (int i = 0; i < MESSAGE.length(); i++) {
            binaryChar = Integer.toBinaryString((int) MESSAGE.charAt(i));
            if (binaryChar.length() < 7) {
                binaryChar7bit.append("0");
                binaryChar7bit.append(binaryChar);
            } else if (binaryChar.length() == 7) {
                binaryChar7bit.append(binaryChar);
            }
        }
        return binaryChar7bit.toString();
    }

    private static void getChuckNorrisEncoding(String binaryString) {
        StringBuilder result = new StringBuilder();
        char currentChar;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '0') {
                result.append("00 ");
                System.out.print("00 ");
                currentChar = '0';
            } else {
                result.append("0 ");
                System.out.print("0 ");
                currentChar = '1';
            }
            while (binaryString.charAt(i) == currentChar) {
                result.append("0");
                System.out.print("0");
                i++;
                if (i >= binaryString.length()) {
                    break;
                }
            }
            if (i < binaryString.length()) {
                result.append(" ");
                System.out.print(" ");
            }
            i--;
        }
    }
}