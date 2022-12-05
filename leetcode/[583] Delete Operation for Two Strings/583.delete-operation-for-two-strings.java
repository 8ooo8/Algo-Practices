/*
 * @lc app=leetcode id=583 lang=java
 *
 * [583] Delete Operation for Two Strings
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        // Get the longest common subsequnce
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char c1 = word1.charAt(i - 1), c2 = word2.charAt(j - 1);
                if (c1 == c2)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return word1.length() + word2.length() - dp[word1.length()][word2.length()] * 2;
    }
}
// @lc code=end
