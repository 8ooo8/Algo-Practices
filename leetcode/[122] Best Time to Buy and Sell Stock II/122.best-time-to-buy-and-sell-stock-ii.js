/*
 * @lc app=leetcode id=122 lang=javascript
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    return prices.map((_, i) => prices[i] - prices[i - 1])
                .slice(1)
                .filter(priceDiff => priceDiff > 0)
                .reduce((sum, priceDiff) => priceDiff + sum, 0);
};
// @lc code=end
