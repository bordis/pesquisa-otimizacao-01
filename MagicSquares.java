// this code is a test to solve the problem using brute force

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MagicSquares {

    public static int size = 3;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int interactions = 0;

        // System.out.print("Enter the size of the board: ");
        // size = sc.nextInt();
        long inicio = System.currentTimeMillis();

        System.out.println("Init the Magic Square puzzle N = " + size);

        int[][] board = generateBoard();

        printBoard(board);

        long fim = System.currentTimeMillis();
        long duracao = fim - inicio;
        double segundos = duracao / 1000.0;

        System.out.printf("Execution time: %.2f s%n", segundos);
        System.out.println("It was necessary " + interactions + " interactions!");

        sc.close();

    }

    public static int[][] generateBoard() {
        int[][] board = new int[size][size];
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= size * size; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        int indVector = 0;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                board[x][y] = numbers.get(indVector);
                indVector++;
            }
        }
        return board;
    }

    // function to print the board
    public static void printBoard(int[][] board) {
        int size = board.length;
        int maxNumber = 0;
        for (int[] row : board) {
            for (int num : row) {
                if (num > maxNumber)
                    maxNumber = num;
            }
        }
        int width = String.valueOf(maxNumber).length() + 1;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                System.out.printf("%" + width + "d", board[x][y]);
            }
            System.out.println();
        }
    }
}
