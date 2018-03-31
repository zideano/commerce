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
        int kthLargest2 = kthLargestElementInArray.findKthLargest(nums, 1);
        int kthLargest3 = kthLargestElementInArray.findKthLargest(nums, 3);

        Assert.assertTrue( kthLargest == 5);
        Assert.assertEquals(6, kthLargest2);
        Assert.assertEquals(4, kthLargest3);

    }
}
