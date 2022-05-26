/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[] countsOf0 = new int[strs.length];
        int[] countsOf1 = new int[strs.length];
        for (int i = 0; i < countsOf0.length; i++) {
            countsOf0[i] = (int)strs[i].chars().filter(c -> c == '0').count();
            countsOf1[i] = (int)strs[i].chars().filter(c -> c == '1').count();
        }

        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int p = 0; p < dp[0].length; p++)
                for (int k = 0; k < dp[0][0].length; k++) {
                    int upperLeftCellP = p - countsOf0[i - 1], upperLeftCellK = k - countsOf1[i - 1];
                    if (upperLeftCellP >= 0 && upperLeftCellK >= 0)
                        dp[i][p][k] = Math.max(1 + dp[i - 1][upperLeftCellP][upperLeftCellK], dp[i - 1][p][k]);
                    else
                        dp[i][p][k] = dp[i - 1][p][k];
                }
        }

        return dp[strs.length][m][n];
    }
}
// @lc code=end
