import leetcode_algorithm.DuplicateNumber;
import org.junit.Assert;
import org.junit.Test;

public class DuplicateNumberTest {

    @Test
    public void testFindDuplicate() {
        DuplicateNumber duplicateNumber = new DuplicateNumber();
        int[] duplicates = {3, 2, 1, 3, 5, 6, 4};

        int duplicate = duplicateNumber.findDuplicate(duplicates);

        Assert.assertEquals(3, duplicate);

        // No duplicates
        int[] duplicates2 = {3, 2, 1, 5, 6, 4};
        int duplicate2 = duplicateNumber.findDuplicate(duplicates2);

        Assert.assertTrue(duplicate2 > duplicates2.length);
    }
}
