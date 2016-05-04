package Puzzles.SinglePlayer.Easy.MimeType;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        //Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        Map<String, String> mime = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            in.nextLine();
            mime.put(EXT.toLowerCase(), MT);
        }
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            String fileExt;
            if (!FNAME.contains(".")) {
                System.out.println("UNKNOWN");
            } else {
                fileExt = FNAME.substring(FNAME.lastIndexOf('.') + 1);
                if (mime.containsKey(fileExt)) {
                    System.out.println(mime.get(fileExt));
                } else if (mime.containsKey(fileExt.toLowerCase())) {
                    System.out.println(mime.get(fileExt.toLowerCase()));
                } else {
                    System.out.println("UNKNOWN");
                }
            }
        }
    }
}