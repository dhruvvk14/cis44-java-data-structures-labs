import java.util.Random;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};
        
        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");
        // int[] test = {1, 2, 3, -6, 5, 0, 150};
        // System.out.println(MaxSubarraySolver.bruteForceMaxSum(test));
        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");
            int x[] = generateRandomArrayWithNegatives(n);

            double t1 = System.nanoTime();
            MaxSubarraySolver.kadanesAlgorithmMaxSum(x);
            double t2 = System.nanoTime();
            MaxSubarraySolver.bruteForceMaxSum(x);
            double t3 = System.nanoTime();
            System.out.println("kadane: " + (t2-t1)/(int)1e9);
            System.out.println("bruteforce: " + (t3-t2)/(int)1e9);
            // TODO: Generate a random array and time both algorithms.
        }
    }

    public static int[] generateRandomArrayWithNegatives(int size) {
        // Implementation provided in previous response
        Random r = new Random();
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = r.nextInt(-1000, 1000);
        }
        return ret;
    }
}