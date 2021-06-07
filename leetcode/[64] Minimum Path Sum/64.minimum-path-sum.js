/*
 * @lc app=leetcode id=64 lang=javascript
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
    const dp = grid.map(v => []);
    grid.forEach((_r, row) => {
        if (row === 0)
            _r.forEach((_c, col) => dp[row][col] = (dp[row]?.[col - 1] ?? 0) + grid[row][col])
        else
            _r.forEach((_c, col) => dp[row][col] = Math.min((dp[row]?.[col - 1] ?? dp[row - 1]?.[col]), dp[row - 1]?.[col]) + grid[row][col]);
    })
    return dp[grid.length - 1][grid[0].length - 1];
};
// @lc code=end
