import leetcode_algorithm.ContainsDuplicate;
import org.junit.Assert;
import org.junit.Test;

public class ContainsDuplicateTest {

    @Test
    public void testHasDuplicate() {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();

        int[] nums = {2, 4, 4, 8, 1, 9, 6, 7, 5};

        boolean duplicate = containsDuplicate.hasDuplicate(nums);

        Assert.assertTrue(duplicate);
    }

    @Test
    public void testHasNoDuplicate() {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();

        int[] nums = {2, 4, 3, 8, 1, 9, 6, 7, 5};

        boolean duplicate = containsDuplicate.hasDuplicate(nums);

        Assert.assertFalse(duplicate);
    }
}
