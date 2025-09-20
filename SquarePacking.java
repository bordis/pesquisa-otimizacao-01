// this code is a test to solve the problem using brute force

public class SquarePacking {
    
    public static void main(String[] args) {

        long inicio = System.currentTimeMillis();

        int interactions = 0;

        System.out.println("Init the N Queens puzzle");



        long fim = System.currentTimeMillis();
        long duracao = fim - inicio;
        System.out.println("Execution time: " + duracao + " ms");
        System.out.println("It was necessary " + interactions + " interactions!");

    }
}
