package leetcode_algorithm;

public class PowerOfTwo {

    /**
     * A number that is a power of 2 can only
     * have one bit of 1.
     * e.g.
     *      2 = 10
     *      4 = 100
     *      8 = 1000
     *      16 = 10000
     *      etc
     *
     * Hence repeatedly right shift one bit at a time
     * and check whether the 1st bit == 1 if true, then
     * this num is not a power of 2.
     *
     * @param num to be evaluated
     * @return true if num ^ 2 else false
     */
    public boolean powerOf2(int num) {
        if (num < 1) {
            return false;
        }

        while (num > 1) {
            if ((num & 1) == 1) {
                return false;
            }

            num >>= 1;
        }

        return true;
    }

    /**
     * Similarly a number that is a power of 2
     * when we subtract 1 from becomes:
     *      2 -> 10 - 1 = 01
     *      4 -> 100 - 1 = 011
     *      8  -> 1000 - 1 = 0111
     *      16 -> 10000 - 1= 01111
     *      etc
     *
     * Therefore, if we perform a binary AND between
     * the original value and the subtracted value
     * then it should be equalled to zero
     *
     *      2 ->    10
     *            & 01
     *            ------
     *            0
     * @param num to be evaluated
     * @return true if num is a power of 2
     */
    public boolean isPowerOf2(int num) {
        if (num <= 0) {
            return false;
        }

        return (num & (num - 1)) == 0;
    }
}
