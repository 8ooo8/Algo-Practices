/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int[] row : dp)
            Arrays.fill(row, 1, row.length, -1);

        for (int coin = 0; coin + 1 < dp.length; coin++) {
            int coinValue = coins[coin];
            for (int value = 0; value < dp[0].length; value++) {
                int upperCell = 0, leftCell = 0;
                boolean upperCellIsPositive = (upperCell = dp[coin][value]) >= 0;
                boolean leftCellIsPositive = value - coinValue >= 0 && (leftCell = dp[coin + 1][value - coinValue]) >= 0;

                if (upperCellIsPositive && leftCellIsPositive)
                    dp[coin + 1][value] = Math.min(upperCell, leftCell + 1);
                else if (upperCellIsPositive)
                    dp[coin + 1][value] = upperCell;
                else if (leftCellIsPositive)
                    dp[coin + 1][value] = leftCell + 1;
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
// @lc code=end
