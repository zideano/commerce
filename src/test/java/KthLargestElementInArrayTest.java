import leetcode_algorithm.KthLargestElementInArray;
import org.junit.Assert;
import org.junit.Test;

public class KthLargestElementInArrayTest {

    @Test
    public void findKthLargestTest() {
        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int kthLargest = kthLargestElementInArray.findKthLargest(nums, k);
        Assert.assertTrue( kthLargest == 5);
    }
}
