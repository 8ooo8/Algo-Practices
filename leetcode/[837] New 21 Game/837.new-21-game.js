/*
 * @lc app=leetcode id=837 lang=javascript
 *
 * [837] New 21 Game
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @param {number} maxPts
 * @return {number}
 */
var new21Game = function(n, k, maxPts) {
    if (k === 0 && n >= 0) return 1;

    const dp = Array(k).fill(0);
    dp[0] = 1;
    let sum = dp[0], count = 1;
    dp.forEach((_, i) => {
        if (i === 0) return;
        // dp[i] = dp.slice(i > maxPts ? i - maxPts : 0, i).reduce((sum, v) => sum + v, 0) / maxPts; // TLE
        dp[i] = sum / maxPts;
        sum += dp[i];
        count++;
        if (count > maxPts) sum -= dp[i - maxPts];
    });

    sum = dp.slice(k > maxPts ? k - maxPts : 0, k).reduce((sum, v) => sum + v, 0);
    [...Array(maxPts).keys()].forEach(i => {
        // dp[k + i] = dp.slice(k + i > maxPts ? k + i - maxPts : 0, k).reduce((sum, v) => sum + v, 0) / maxPts; // TLE
        dp[k + i] = sum / maxPts;
        sum -= dp[k + i - maxPts] ?? 0;
    });

    return dp.slice(k, n + 1).reduce((sum, v) => sum + v, 0);
};
// @lc code=end
