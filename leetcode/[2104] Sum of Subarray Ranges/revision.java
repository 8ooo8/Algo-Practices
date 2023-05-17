/*
 * @lc app=leetcode id=2104 lang=java
 *
 * [2104] Sum of Subarray Ranges
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public long subArrayRanges(int[] nums) {
        long ret = 0;
        for (int i = 1; i < nums.length; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                ret += (long)max - min;
            }
        }
        
        return ret;
    }
}
// @lc code=end
