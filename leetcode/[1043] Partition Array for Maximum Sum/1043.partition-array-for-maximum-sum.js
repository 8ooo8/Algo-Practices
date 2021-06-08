/*
 * @lc app=leetcode id=1043 lang=javascript
 *
 * [1043] Partition Array for Maximum Sum
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */
var maxSumAfterPartitioning = function(arr, k) {
    const dp = Array(arr.length).fill(0);
    dp[0] = arr[0];
    const getMax = (from, to) => arr.slice(from >= 0 ? from : 0, to + 1 <= arr.length ? to  + 1: arr.length).reduce((max, num) => Math.max(max, num));
    [...arr.keys()].slice(1).forEach(i => {
        dp[i] = Array(k).fill().reduce((max, _, j) => Math.max(max, getMax(i - j, i) * (i - j >= 0 ? j + 1 : i + 1) + (dp[i - j - 1] ?? 0)), Number.NEGATIVE_INFINITY);
    });
    return dp.slice(-1)[0];
};
// @lc code=end
