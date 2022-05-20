/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int[] maxPrices = new int[prices.length];
        maxPrices[prices.length - 1] = prices[prices.length - 1];
        for (int i = maxPrices.length - 2; i > 0; i--)
            maxPrices[i] = Math.max(prices[i], maxPrices[i + 1]);
        for (int i = 0; i < prices.length - 1; i++)
            ans = Math.max(ans, maxPrices[i + 1] - prices[i]);
        return ans;
    }
}
// @lc code=end
