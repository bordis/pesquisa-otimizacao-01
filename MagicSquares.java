import java.util.*;

public class MagicSquares {

    public static int size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the board size: ");
        size = sc.nextInt();

        // generate the board size
        int boardSize = size * size;

        // calculate the "magic number"
        int magicSum = size * (size * size + 1) / 2;

        System.out.println("Init the Magic Squares puzzle " + size + "x" + size + ", with the Magic Sum " + magicSum);
        long countTimeInit = System.currentTimeMillis();
        // generate all perm of size of the board
        Perm perm = new Perm(boardSize, 1);
        int solutionCount = 0;

        for (List<Integer> candidate : perm) {
            // System.err.println(candidate);
            int[] board = new int[candidate.size()];

            // convert to int[]
            for (int i = 0; i < candidate.size(); i++) {
                board[i] = candidate.get(i);
            }

            if (isValid(board, magicSum)) {
                // System.out.println("Solution found:");
                // printBoard(board, size);
                solutionCount++;
            }
        }
        long countTimeEnd = System.currentTimeMillis();
        long countExecutionTime = countTimeEnd - countTimeInit;
        double seconds = countExecutionTime / 1000.0;
        System.out.println("Total of possibilities: " + solutionCount);
        System.out.printf("Execution time: %.2f s%n", seconds);
        sc.close();
    }

    private static boolean isValid(int[] board, int magicSum) {
        // test the sum of the lines
        for (int i = 0; i < size; i++) {
            int sum = 0;
            for (int j = 0; j < size; j++) {
                sum += board[i * size + j];
            }
            if (sum != magicSum)
                return false;
        }

        // test the sum of the columns
        for (int j = 0; j < size; j++) {
            int sum = 0;
            for (int i = 0; i < size; i++) {
                sum += board[i * size + j];
            }
            if (sum != magicSum)
                return false;
        }

        // teste de diagonal TL to BR
        int diag1 = 0;
        for (int i = 0; i < size; i++) {
            diag1 += board[i * size + i];
        }
        if (diag1 != magicSum)
            return false;

        // teste de diagonal TR to BL
        int diag2 = 0;
        for (int i = 0; i < size; i++) {
            diag2 += board[i * size + (size - 1 - i)];
        }
        if (diag2 != magicSum)
            return false;

        return true;
    }

    private static void printBoard(int[] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%2d ", board[i * N + j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}