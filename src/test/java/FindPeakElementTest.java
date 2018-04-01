import leetcode_algorithm.FindPeakElement;
import org.junit.Assert;
import org.junit.Test;

public class FindPeakElementTest {

    @Test
    public void findPeakTest() {
        FindPeakElement findPeakElement = new FindPeakElement();
        int[] arr = {1, 2, 3, 1};

        int peakIndex = findPeakElement.findPeak(arr);

        Assert.assertEquals(2, peakIndex);
    }

    @Test
    public void findPeakLogarithmicTest() {
        FindPeakElement findPeakElement = new FindPeakElement();
        int[] arr = {1, 2, 3, 1};

        int peakIndex = findPeakElement.findPeakWithLogComplexity(arr);

        Assert.assertEquals(2, peakIndex);
    }
}
