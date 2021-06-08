/*
 * @lc app=leetcode id=714 lang=javascript
 *
 * [714] Best Time to Buy and Sell Stock with Transaction Fee
 */

// @lc code=start
/**
 * @param {number[]} prices
 * @param {number} fee
 * @return {number}
 */
var maxProfit = function(prices, fee) {
    return prices.slice(1).reduce((maxProfit, price) => {
        maxProfit.oneStockInHand = Math.max(maxProfit.oneStockInHand, maxProfit.zeroStockInHand - price);
        maxProfit.zeroStockInHand = Math.max(maxProfit.zeroStockInHand, maxProfit.oneStockInHand + price - fee);
        return maxProfit;
    }, {oneStockInHand: -prices[0], zeroStockInHand: 0}).zeroStockInHand;

};
// @lc code=end
