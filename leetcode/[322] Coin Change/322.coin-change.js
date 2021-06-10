/*
 * @lc app=leetcode id=322 lang=javascript
 *
 * [322] Coin Change
 */

// @lc code=start
/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {
    if (amount === 0) return 0;
    if (coins.every(c => c % 2 === 0) && amount % 2) return -1;

    const dp = Array(amount + 1).fill(Number.POSITIVE_INFINITY);
    // const dp = Array(amount + 1).fill();
    coins.forEach(c => { if (c <= amount) dp[c] = 1 } );
    dp.forEach((minAmount, i) => {
        dp[i] = Math.min(dp[i], coins.reduce((minAmount, c) => Math.min(minAmount, (dp[i - c] ?? Number.POSITIVE_INFINITY) + 1), Number.POSITIVE_INFINITY));
    });
    // dp.forEach((minAmount, i) => {
        // if (minAmount === undefined) return;
        // coins.forEach(c => dp[i + c] = Math.min(dp[i + c] ?? Number.POSITIVE_INFINITY, dp[i] + 1));
    // });
    // return isNaN(dp[amount]) ? -1 : dp[amount];
    return isFinite(dp[amount]) ? dp[amount] : -1;
};
// @lc code=end
