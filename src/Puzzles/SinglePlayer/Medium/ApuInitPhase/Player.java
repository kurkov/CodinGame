package Puzzles.SinglePlayer.Medium.ApuInitPhase;

import java.util.Scanner;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        in.nextLine();
        Node[][] nodeArray = new Node[height][width];
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '0') {
                    nodeArray[i][j] = new Node(j, i);
                } else {
                    nodeArray[i][j] = new Node(-1, -1);
                }
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x + 1 != width) {
                    nodeArray[y][x].rightNeighbour = nodeArray[y][x+1];
                } else {
                    nodeArray[y][x].rightNeighbour = new Node(-1, -1);
                }

                if (y + 1 != height) {
                    nodeArray[y][x].bottomNeighbour = nodeArray[y+1][x];
                } else {
                    nodeArray[y][x].bottomNeighbour = new Node(-1, -1);
                }
            }
        }


        // Three coordinates: a node, its right neighbor, its bottom neighbor
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(nodeArray[i][j].toString());
                if (j + 1 != width) {
                    System.out.print(" ");
                }
                System.out.println();
            }
        }

    }

    private static class Node {
        int x, y;
        Node rightNeighbour;
        Node bottomNeighbour;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void getRightNeighbour() {
            System.out.print(this.rightNeighbour.x + " " + this.rightNeighbour.y);
        }

        public void getBottomNeighbour() {
            System.out.print(this.bottomNeighbour.x + " " + this.bottomNeighbour.y);
        }

        @Override
        public String toString() {
            return this.x + " " + this.y + " "
                    + rightNeighbour.x + " " + rightNeighbour.y + " "
                    + bottomNeighbour.x + " " + bottomNeighbour.y;
        }
    }
}