import java.util.*;

public class Queens {

    public static int size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the board size: ");
        size = sc.nextInt();
        long countTimeInit = System.currentTimeMillis();

        // generate all perm of size of the board
        Perm perm = new Perm(size);

        // just to see all perm
        // for (List<Integer> valores : perm) {
        //     System.out.println(valores);
        // }

        // list to store all solutions
        List<int[]> solutions = new ArrayList<>();

        for (List<Integer> candidate : perm) {
            // System.err.println(candidate);
            int[] queens = new int[candidate.size()];

            // convert to int[]
            for (int i = 0; i < candidate.size(); i++) {
                queens[i] = candidate.get(i);
            }

            // check if the solution is valid
            // where the index is the column and the value is the row
            // print the board only to see the positions to test
            // printBoard(queens);
            if (isValid(queens)) {
                // coment the prints to improve execution time
                // System.out.println("Solution found:");
                // printBoard(queens);
                solutions.add(queens);
            }
        }

        long countTimeEnd = System.currentTimeMillis();
        long countExecutionTime = countTimeEnd - countTimeInit;
        double seconds = countExecutionTime / 1000.0;
        System.out.println("Total of possibilities: " + solutions.size());
        System.out.printf("Execution time: %.2f s%n", seconds);
        sc.close();
    }

    // validate if the queens positions are valid
    private static boolean isValid(int[] queens) {
        // need to check if two queens are in the same diagonal
        // perm class already guarantee that no two queens are in the same row or column
        for (int i = 0; i < size; i++) {
            // for to not repeat board positions
            for (int j = i + 1; j < size; j++) {
                // calculate the difference
                int dx = j - i;
                // asb to get the positive value/distance
                int dy = Math.abs(queens[j] - queens[i]);
                // if the difference is the same, they are in the same diagonal
                if (dy == dx) {
                    return false;
                }
            }
        }
        return true;
    }

    // function to print the board
    // just to see the positions to test 
    private static void printBoard(int[] queens) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (queens[col] == row) {
                    System.out.print(" x");
                } else {
                    System.out.print(" o");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}