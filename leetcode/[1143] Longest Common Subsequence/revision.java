/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text2.length() + 1][text1.length() + 1];
        for (int i = 1; i < text2.length() + 1; i++)
            for (int j = 1; j < text1.length() + 1; j++)
                dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1] + (text2.charAt(i - 1) == text1.charAt(j - 1) ? 1 : 0)));
        return dp[text2.length()][text1.length()];
    }
}
// @lc code=end
