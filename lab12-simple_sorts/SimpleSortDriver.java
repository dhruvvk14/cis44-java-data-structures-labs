import java.util.Arrays;
import java.util.Comparator;

public class SimpleSortDriver {
    public static void main(String[] args) {
        // Use a standard Integer comparator
        Comparator comp = Comparator.naturalOrder();

        // Test 1: Unsorted Array
        Integer[] arr1 = {5, 1, 9, 3, 7, 6};
        Integer[] arr1_copy = Arrays.copyOf(arr1, arr1.length);

        System.out.println("--- Test 1: Unsorted Array ---");
        System.out.println("Original: " + Arrays.toString(arr1));
        SimpleSorters.bubbleSort(arr1, comp);
        System.out.println("Bubble Sort: " + Arrays.toString(arr1));

        System.out.println("Original: " + Arrays.toString(arr1_copy));
        SimpleSorters.insertionSort(arr1_copy, comp);
        System.out.println("Insertion Sort: " + Arrays.toString(arr1_copy));

        // TODO: Add Test 2 (Reverse-Sorted) and Test 3 (Already-Sorted)
    }
}