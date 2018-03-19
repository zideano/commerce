import org.junit.Assert;
import org.junit.Test;
import sorting.SortingUtils;

import java.util.Arrays;

public class SortingUtilsTest {

    @Test
    public void testReverseStringMethod() {
        String original = "original";

        String reverse = SortingUtils.reverseString(original);

        Assert.assertNotEquals(original, reverse);
        Assert.assertEquals("lanigiro", reverse);
        Assert.assertEquals(original, SortingUtils.reverseString(reverse));
    }

    @Test
    public void testBinarySearchMethodWithPrimitives() {
        int[] arr = {2, 89, 1, 3, 56, 10, 23, 8, 9};
        int key = 10;

        Arrays.sort(arr);

        int index = SortingUtils.binarySearch(arr, key);
        Assert.assertTrue(index == 5);
    }

    @Test
    public void testSortingMethods() {
        int[] arr = {2, 89, 1, 3, 56, 10, 23, 8, 9};
        int[] sorted_arr = {1, 2, 3, 8, 9, 10, 23, 56, 89};

        int[] sorted = SortingUtils.bubbleSort(arr);
        Assert.assertArrayEquals(sorted_arr, sorted);

        int[] sorted2 = SortingUtils.insertionSort(arr);
        Assert.assertArrayEquals(sorted_arr, sorted2);
    }

}
