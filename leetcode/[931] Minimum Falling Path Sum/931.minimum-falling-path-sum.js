/*
 * @lc app=leetcode id=931 lang=javascript
 *
 * [931] Minimum Falling Path Sum
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @return {number}
 */
var minFallingPathSum = function(matrix) {
    const dp = matrix.map(row => []);
    dp[0] = matrix[0];
    matrix.forEach((_, row) => {
        if (row === 0) return;
        _.forEach((_, col) => 
            dp[row][col] = Math.min(dp[row - 1][col - 1] ?? Number.POSITIVE_INFINITY, dp[row - 1][col], dp[row - 1][col + 1] ?? Number.POSITIVE_INFINITY) + matrix[row][col]
        );
    });
    return dp.slice(-1)[0].reduce((minSum, sum) => Math.min(minSum, sum)) 
};
// @lc code=end
