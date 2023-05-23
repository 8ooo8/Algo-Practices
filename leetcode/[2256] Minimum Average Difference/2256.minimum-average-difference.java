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
        int N = nums.length;
        long[] sums = new long[N];
        for (int i = 0; i < N; i++)
            sums[i] = nums[i] + (i > 0 ? sums[i - 1] : 0);

        long minAverageDiff = Integer.MAX_VALUE, minAverageDiffIdx = 0, firstAverage, lastAverage;
        for (int i = 0; i < N; i++) {
            firstAverage = sums[i] / (i + 1);
            lastAverage = i == N - 1 ? 0 : (sums[N - 1] - sums[i]) / (N - i - 1);
            // System.out.println(Arrays.toString(new int[]{firstAverage, lastAverage}));
           long newMinAverageDiff = Math.abs(firstAverage - lastAverage);
            if (newMinAverageDiff < minAverageDiff) {
                minAverageDiff = newMinAverageDiff;
                minAverageDiffIdx = i;
            }
        }

        return (int)minAverageDiffIdx;
    }
}
// @lc code=end
