import java.util.*;

public class Cryptarithmetic {

    public static void main(String[] args) {
        System.out.println("Init the cryptarithmetic puzzle TWO + TWO = FOUR");
        // cont all possible variables to T, W, O, F, U, R
        int numVars = 6;
        // the base going to be 0 to 9
        int base = 10;

        // create all the combs
        Comb comb = new Comb(numVars, base);

        // just to see all combs
        // for(List<Integer> valores : comb) {
        // System.out.println(valores);
        // }

        int countSolutions = 0;
        long countTimeInit = System.currentTimeMillis();

        // for all the combs
        for (List<Integer> valores : comb) {
            int t = valores.get(0);
            int w = valores.get(1);
            int o = valores.get(2);
            int f = valores.get(3);
            int u = valores.get(4);
            int r = valores.get(5);

            // not consider the cases where T or F are 0
            // the numbers must start > 0
            if (t == 0 || f == 0)
                continue;

            // check if all the 6 values are distinct
            Set<Integer> unicos = new HashSet<>(valores);
            if (unicos.size() != 6)
                continue;

            // calculate the numbers
            int two = 100 * t + 10 * w + o;
            int four = 1000 * f + 100 * o + 10 * u + r;

            // Test the solucion
            if (2 * two == four) {
                // coment the prints to improve execution time
                // System.out.println("Solucion found!");
                // System.out.println("   " + two);
                // System.out.println(" + " + two);
                // System.out.println("--------");
                // System.out.println("   " + four);
                // System.out.printf("Values: T=%d, W=%d, O=%d, F=%d, U=%d, R=%d%n%n",
                //         t, w, o, f, u, r);
                countSolutions++;
            }
        }
        long countTimeEnd = System.currentTimeMillis();
        long countExecutionTime = countTimeEnd - countTimeInit;
        double seconds = countExecutionTime / 1000.0;
        System.out.println("Total of possibilities: " + countSolutions);
        System.out.printf("Execution time: %.2f s%n", seconds);

    }
}