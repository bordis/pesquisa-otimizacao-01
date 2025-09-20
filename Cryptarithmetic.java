// this code is a test to solve the problem using brute force

import java.util.Random;

public class Cryptarithmetic {
    // main class
    public static void main(String[] args) {
        Random rand = new Random();

        long inicio = System.currentTimeMillis();

        System.out.println("Init the cryptarithmetic puzzle TWO + TWO = FOUR");

        int interactions = 0;

        while (true) {
            // set ramdon number to the letters
            int t = rand.nextInt(10);
            int w = rand.nextInt(10);
            int o = rand.nextInt(10);
            int f = rand.nextInt(10);
            int u = rand.nextInt(10);
            int r = rand.nextInt(10);
            
            // calculanting the word "two"
            int two = t * 100 + w * 10 + o;

            // calculating the word "four"
            int four = f * 1000 + o * 100 + u * 10 + r;

            if (two + two == four) {
                System.out.println("Find the match!!!");
                System.out.println("   " + two);
                System.out.println(" + " + two);
                System.out.println("--------");
                System.out.println("   " +four);
                break;
            }
            interactions++;
        }
        long fim = System.currentTimeMillis();
        long duracao = fim - inicio;
        System.out.println("Execution time: " + duracao + " ms");
        System.out.println("It was necessary "+interactions+" interactions!");
    }

}
