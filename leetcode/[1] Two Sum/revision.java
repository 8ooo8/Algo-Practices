/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> rests = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if (rests.containsKey(rest))
                return new int[]{rests.get(rest), i};
            rests.put(nums[i], i);
        }
        return null; // undefined behaviour
    }
}
// @lc code=end
