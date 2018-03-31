package leetcode_algorithm;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length-1);
    }

    private int quickSelect(int[] nums, int k, int left, int right) {
        int pos = partition(nums, left, right);

        if (pos == k-1) {
            return nums[pos];
        }

        if (pos < k-1) {
            return quickSelect(nums, k, pos+1, right);
        } else {
            return quickSelect(nums, k, left, pos-1);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = left++;

        while (left <= right) {
            while (left <= right && nums[left] >= nums[pivot]) {
                left++;
            }

            while (right >= left && nums[right] < nums[pivot]) {
                right--;
            }

            if (left > right) {
                break;
            }

            swap(nums, left, right);
        }

        swap(nums, pivot, right);
        return right;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
