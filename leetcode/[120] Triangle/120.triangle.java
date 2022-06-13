/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int row = 1; row < dp.length; row++) {
            dp[row][0] = dp[row - 1][0] + triangle.get(row).get(0);
            for (int col = 1; col < row; col++) {
                dp[row][col] = Math.min(dp[row - 1][col - 1], dp[row - 1][col]) + triangle.get(row).get(col);
            }
            dp[row][row] = dp[row - 1][row - 1] + triangle.get(row).get(row);
        }
        // for (int[] row : dp) System.out.println(Arrays.toString(row));
        return Arrays.stream(dp[dp.length - 1]).min().getAsInt();
    }
}
// @lc code=end
