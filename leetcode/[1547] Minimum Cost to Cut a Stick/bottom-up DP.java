/*
 * @lc app=leetcode id=1547 lang=java
 *
 * [1547] Minimum Cost to Cut a Stick
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int minCost(int n, int[] cuts) {
        final int m = cuts.length;
        int[] sortedCuts = new int[m + 2];
        System.arraycopy(cuts, 0, sortedCuts, 1, m);
        sortedCuts[0] = 0;
        sortedCuts[m + 1] = n;
        Arrays.sort(sortedCuts);
        
        int[][] dp = new int[m + 2][m + 2];
        for (int range = 2; range <= m + 1; range++) {
            for (int left = 0, right = range; right <= m + 1; ++left, ++right) {
                dp[left][right] = Integer.MAX_VALUE;
                for (int mid = left + 1; mid < right; ++mid)
                    dp[left][right] = Math.min(dp[left][right], dp[left][mid] + dp[mid][right] + sortedCuts[right] - sortedCuts[left]);
            }
        }
        return dp[0][m + 1];
    }
}
// @lc code=end
