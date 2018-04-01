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
        Assert.assertEquals(5, index);
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

    @Test
    public void testSelectionSort() {
        int[] arr = new int[] {2, 89, 1, 3, 56, 10, 23, 8, 9};
        int[] sorted_arr = {1, 2, 3, 8, 9, 10, 23, 56, 89};
        int[] unsorted_arr = {2, 1, 3, 8, 9, 10, 23, 56, 89};

        int[] sorted = SortingUtils.selectionSort(arr);
        Assert.assertArrayEquals("These arrays should be equal", sorted_arr, sorted);

        Assert.assertNotNull(sorted);
        Assert.assertNotEquals(unsorted_arr, sorted);
    }

    @Test
    public void testQuickSort() {
        int[] arr = {2, 89, 1, 3, 56, 10, 23, 8, 9};
        int[] sorted_arr = {1, 2, 3, 8, 9, 10, 23, 56, 89};

        SortingUtils.quickSort(arr, 0, arr.length-1);
        Assert.assertArrayEquals("These two arrays should now be equalled", sorted_arr, arr);

    }

}
