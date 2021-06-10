/*
 * @lc app=leetcode id=813 lang=javascript
 *
 * [813] Largest Sum of Averages
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var largestSumOfAverages = function(nums, k) {
    const getAverage = (from, to) => nums.slice(from, to + 1).reduce((sum, num) => sum + num) / (to - from + 1);

    const dp = Array(k).fill().map(_ => []);
    dp[0] = nums.map((_, i) => getAverage(0, i));
    dp.forEach((_, i) => {
        if (i === 0) return;
        nums.forEach((_, j) => 
            Array(j + 1).fill().forEach((_, p) => dp[i][j] = Math.max(dp[i][j] ?? Number.NEGATIVE_INFINITY, (dp[i - 1][p - 1] ?? 0) + getAverage(p, j)))
        );
    });
    return dp.slice(-1)[0].slice(-1)[0];
};
// @lc code=end
