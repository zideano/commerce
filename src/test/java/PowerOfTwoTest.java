import leetcode_algorithm.PowerOfTwo;
import org.junit.Assert;
import org.junit.Test;

public class PowerOfTwoTest {

    @Test
    public void testPowerOf2() {
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        boolean b = powerOfTwo.powerOf2(5);
        boolean b1 = powerOfTwo.powerOf2(4);
        boolean b2 = powerOfTwo.powerOf2(10);

        Assert.assertFalse(b);
        Assert.assertTrue(b1);
        Assert.assertFalse(b2);
    }

    @Test
    public void testIsPowerOf2() {
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        boolean b = powerOfTwo.isPowerOf2(7);
        boolean b1 = powerOfTwo.isPowerOf2(8);
        boolean b2 = powerOfTwo.isPowerOf2(100);

        Assert.assertFalse(b);
        Assert.assertTrue(b1);
        Assert.assertFalse(b2);
    }
}
