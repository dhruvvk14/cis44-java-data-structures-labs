public class MaxSubarraySolver {

    /**
     * Finds the maximum subarray sum using a brute-force approach.
     * Theoretical Complexity: O(n^2)
     */
    public static int bruteForceMaxSum(int[] arr) {
        int n = arr.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (ret < sum)ret = sum;
            }
        }
        return ret; // Placeholder
    }

    /**
     * Finds the maximum subarray sum using Kadane's Algorithm.
     * Theoretical Complexity: O(n)
     */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        // TODO: Implement the O(n) Kadane's Algorithm.
        int sum = 0;
        int n = arr.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum <= 0) sum = 0;
            if (ret < sum) ret = sum;
        }
        return ret; // Placeholder
    }
}
