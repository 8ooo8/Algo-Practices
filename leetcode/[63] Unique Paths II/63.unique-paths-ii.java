/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        dp[0][1] = 1;
        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[0].length; col++)
                if (obstacleGrid[row - 1][col - 1] == 0)
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
// @lc code=end
