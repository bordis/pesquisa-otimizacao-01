// this code is a test to solve the problem using brute force
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Queens {

    public static int size;
    public static int interactions = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the board: ");
        size = sc.nextInt();

        System.out.println("The size going to be: " + size);

        long inicio = System.currentTimeMillis();
        System.out.println("Init the N Queens puzzle");

        int[][] board = generateQuenns();

        while (true) {
            if (!validateBoard(board)) {
                board = generateQuenns();
            } else {
                break;
            }
        }

        printBoard(board);

        long fim = System.currentTimeMillis();
        long duracao = fim - inicio;
        double segundos = duracao / 1000.0;

        System.out.printf("Execution time: %.2f s%n", segundos);
        System.out.println("It was necessary " + interactions + " interactions!");

        sc.close();

    }

    // function to validate the board
    public static boolean validateBoard(int[][] board) {
        interactions++;
        // not allow queens in the same line
        Set<Integer> line = new HashSet<>();
        int[] positions = new int[size];
        for (int x = 0; x < size; x++) {
            int quennLine = 0;
            for (int y = 0; y < size; y++) {
                if (board[x][y] == 1) {
                    quennLine = y;
                }
            }
            // quick check, HashSet dont allow sames values, so its must be one queen in diferente line position
            if (!line.add(quennLine)) {
                return false;
            } else {
                positions[x] = quennLine;
            }
        }
        // for all the quenns
        // dont compare with the last queen, already compare int the loop
        for (int i = 0; i < positions.length - 1; i++) {
            // get the quem possition of the +1 i, to not compare with the same queen
            for (int j = i + 1; j < positions.length; j++) {
                // do the calc line x position, if the result is equal is in a invalid position
                // first contidion have the absolute of the line and second of the columm
                if (Math.abs(i - j) == Math.abs(positions[i] - positions[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    // funtion to generate random quenns
    public static int[][] generateQuenns() {
        int[][] board = new int[size][size];
        for (int x = 0; x < size; x++) {
            Random rand = new Random();
            int quenn = rand.nextInt(size);
            for (int y = 0; y < size; y++) {
                if (y == quenn) {
                    board[x][y] = 1;
                }
            }
        }
        return board;
    }

    // function to print the board
    public static void printBoard(int[][] board) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (board[x][y] == 1) {
                    System.out.print("  x");
                } else {
                    System.out.print("  o");
                }

            }
            System.out.println();
        }
    }

}
