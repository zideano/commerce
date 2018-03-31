package leetcode_algorithm;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /**
     * This method finds the first duplicate element
     * within an array.
     *
     * @param nums is an array of integers
     * @return true if a duplicate is found and false if not
     */
    public boolean hasDuplicate(int[] nums) {

        if (nums.length == 0) {
            return false;
        }

        Set<Integer> appeared = new HashSet<>();

        for (int num : nums) {

            /*
             * If num is already inside the hash set
             * add method returns false, therefore
             * we found a duplicate
             */
            if (!appeared.add(num)) {
                return true;
            }
        }

        return false;
    }
}
