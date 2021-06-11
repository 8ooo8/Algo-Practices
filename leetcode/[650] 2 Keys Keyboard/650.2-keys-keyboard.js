/*
 * @lc app=leetcode id=650 lang=javascript
 *
 * [650] 2 Keys Keyboard
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var minSteps = function(n) {
    if (n === 1) return 0;
    const dp = Array(n).fill().map(_ => []);
    dp[0][0] = 1;
    dp.forEach((_, i) => {
        if (i === 0) return;
        dp.slice(Math.floor(i / 2), i).map((minSteps, j) => ({minSteps: minSteps, j: j + Math.floor(i / 2) })).forEach(({minSteps, j}) => {
            if (!isNaN(dp[j][i - j - 1])) dp[i][i - j - 1] = Math.min(dp[i][i - j - 1] ?? Number.POSITIVE_INFINITY, dp[j][i - j - 1] + 1);
        });
        dp[i][i] = dp[i].reduce((minSteps, steps) => Math.min(minSteps, steps)) + 1;
    });
    return dp.slice(-1).flat().reduce((minSteps, steps) => Math.min(minSteps, steps))
};
// @lc code=end
