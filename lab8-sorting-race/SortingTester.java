import java.util.Arrays;
import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};
        
        SortingAlgorithms s = new SortingAlgorithms();

        // System.out.println("--- The Sorting Race ---");

        int [] sort = {7, 5, 3, 1, 2, 4, 8, 6};
        int a1[] = {1, 2};
        // int a2[] = {2, 3, 5};
        // int temp[] = {1,2,3,2,3,5};
        // SortingAlgorithms.mergeSort(sort);
        
        // SortingAlgorithms.insertionSort(sort);
        // for (int i:sort) System.out.print(i + " ");
        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");
            
            double t1 = System.nanoTime();
            SortingAlgorithms.mergeSort(generateReverseSortedArray(n));
            double t2 = System.nanoTime();
            System.out.println((t2-t1)/((int)1e9));
            // TODO: Call your test methods for Average, Best, and Worst cases.
        }
    }
    

    public static int[] generateRandomArray(int size) {
        int arr[] = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(0, 1500000);
        }
        return arr;
    }

    public static int[] generateSortedArray(int size) {
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i+1;
        return arr;
    }

    public static int[] generateReverseSortedArray(int size) {
        int arr[] = new int[size];
        for (int i = size-1; i >= 0; i--) arr[i] = size-i;
        return arr;
    }
}