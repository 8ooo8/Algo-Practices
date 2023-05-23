/*
 * @lc app=leetcode id=2256 lang=java
 *
 * [2256] Minimum Average Difference
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int minimumAverageDifference(int[] nums) {
        long lastSum = 0, firstSum = 0, N = nums.length;
        for (int n : nums) lastSum += n;

        int minAverageDiff = Integer.MAX_VALUE, minAverageDiffIdx = 0;
        for (int i = 0; i < N; i++) {
            firstSum += nums[i];
            lastSum -= nums[i];
            int newMinAverageDiff = Math.abs((int)(firstSum / (i + 1) - (i == N - 1 ? 0 : lastSum / (N - i - 1))));
            if (newMinAverageDiff < minAverageDiff) {
                minAverageDiff = newMinAverageDiff;
                minAverageDiffIdx = i;
            }
        }

        return minAverageDiffIdx;
    }
}
// @lc code=end
