/*
 * @lc app=leetcode id=121 lang=javascript
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    if (prices.length <= 1) return 0;

    let maxProfit = 0;
    let minPrice = prices[0];
    prices.slice(1).forEach(price => {
        minPrice = Math.min(minPrice, price);
        maxProfit = Math.max(maxProfit, price - minPrice);
    });

    return maxProfit;
};
// @lc code=end
