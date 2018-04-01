package leetcode_algorithm;

/**
 * Find the peak element within an array
 * with logarithmic O(log(n)) and O(n) complexity
 *
 * array = [1, 2, 3, 1] -> peek = 3
 */
public class FindPeakElement {

    /**
     * Performs in O(n)
     *
     * @param arr
     * @return index of peak element
     */
    public int findPeak(int[] arr) {
        int previous = Integer.MIN_VALUE;
        int current;
        int next;

        for (int i = 0; i < arr.length; i++) {
            current = arr[i];
            next = arr[i + 1];

            if (next < current && current > previous) {
                return i;
            }
        }

        return arr.length - 1;
    }

    /**
     * Performs in O(log(n)) using binary search
     * to find a peak element when left == right
     *
     * @param arr
     * @return index of peak element
     */
    public int findPeakWithLogComplexity(int[] arr) {
        int length = arr.length;
        int left = 0;
        int right = length - 1;
        int peak = 0;

        while (left <= right) {

            if (left == right) {
                peak = left;
                break;
            }

            int mid = (left + right) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return peak;
    }
}
