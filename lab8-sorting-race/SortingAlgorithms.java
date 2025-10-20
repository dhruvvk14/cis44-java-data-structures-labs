import java.util.Arrays;
public class SortingAlgorithms {

    /**
     * Implements the Selection Sort algorithm.
     * Theoretical Complexity: O(n^2)
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int mn = (int)1e9 + 7;
            for (int j = i; j < n; j++) mn = Math.min(mn, arr[j]);
            for (int j = n-1; j >= i; j--) {
                if (arr[j] == mn) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    break;
                }
            }
        }
    }

    /**
     * Implements the Insertion Sort algorithm.
     * Theoretical Complexity: O(n^2) / Best-Case: O(n)
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i-1;
            int key = arr[i];
            while(0 <= j && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    /**
     * Implements the Merge Sort algorithm. Public-facing method.
     * Theoretical Complexity: O(n log n)
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;


        int[] temp = mergeSortRecursive(arr);

        System.arraycopy(temp, 0, arr, 0, arr.length);
    // arr = Arrays.copyOf(temp, arr.length);
    }

    private static int[] mergeSortRecursive(int[] arr) {
        if (arr.length <= 1) return arr;
        int m = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, m);
        int[] right = Arrays.copyOfRange(arr, m, arr.length);
        return merge(mergeSortRecursive(left), mergeSortRecursive(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        int n = left.length, m = right.length;
        while (i < n && j < m) {
            if (left[i] <= right[j]) {
                result[k] = left[i];
                k++; i++;
            }
            else {
                result[k] = right[j];
                k++; j++;
            }
        }

        while (i < left.length) {
            result[k] = left[i];
            k++; i++;
        }
        while (j < right.length){
            result[k] = right[j];
            k++; j++;
        }

        return result;
    }

}