package leetcode_algorithm;

/**
 * Find the duplicate number within an array
 */
public class DuplicateNumber {

    /**
     *
     * @param nums
     * @return duplicate number
     */
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (low + high) / 2;

            int count = 0;

            for (int a : nums) {

                if (a <= mid) {
                    count++;
                }

            }

            if (count <= mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
