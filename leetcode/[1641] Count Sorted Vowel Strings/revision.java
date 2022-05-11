/*
 * @lc app=leetcode id=1641 lang=java
 *
 * [1641] Count Sorted Vowel Strings
 */

// @lc code=start
class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n][6];
        for (int c = 1; c < dp[0].length; c++)
            dp[0][c] = 1;
        for (int r = 1; r < dp.length; r++)
            for (int c = 1; c < dp[0].length; c++)
                dp[r][c] = dp[r][c - 1] + dp[r - 1][c];
        return IntStream.of(dp[n - 1]).sum();
    }
}
// @lc code=end
