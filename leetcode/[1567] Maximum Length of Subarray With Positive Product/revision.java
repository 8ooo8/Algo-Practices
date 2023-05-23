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
        int firstNegative = -1, lastNegative = -1, negativeCount = 0, startFrom = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                firstNegative = -1;
                lastNegative = -1;
                negativeCount = 0;
                startFrom = i + 1;
            } else if (nums[i] < 0) {
                if (firstNegative < 0)
                    firstNegative = i;
                else if (lastNegative < 0)
                    lastNegative = i;
                negativeCount++;
            }

            if (negativeCount % 2 == 0)
                maxLen = Math.max(maxLen, i - startFrom + 1);
            else {
                if (firstNegative >= 0) {
                    maxLen = Math.max(Math.max(firstNegative - startFrom, i - firstNegative), maxLen);
                }
                if (lastNegative >= 0)
                    maxLen = Math.max(Math.max(lastNegative - startFrom, i - lastNegative), maxLen);
            }
        }
        return maxLen;
    }
}
// @lc code=end
