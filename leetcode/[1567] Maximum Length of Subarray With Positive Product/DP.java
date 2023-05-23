/*
 * @lc app=leetcode id=1567 lang=java
 *
 * [1567] Maximum Length of Subarray With Positive Product
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int getMaxLen(int[] nums) {
        int maxLen = 0;
        int negative = -1, positive = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                negative = -1;
                positive = 0;
            } else if (nums[i] > 0) {
                ++positive;
                negative += negative >= 0 ? 1 : 0;
            } else {
                int originalPositive = positive;
                positive = negative + 1;
                negative = originalPositive + 1;
            }
            maxLen = Math.max(positive, maxLen);
        }
        return maxLen;
    }
}
// @lc code=end
