/*
 * @lc app=leetcode id=1260 lang=javascript
 *
 * [1260] Shift 2D Grid
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @param {number} k
 * @return {number[][]}
 */
var shiftGrid = function(grid, k) {
    const m = grid.length, n = grid[0].length;
    const shifted = [...Array(m)].map(row => Array(n));
    for (let t = 0; t < k; t++) {
        for (let i = 0; i < m; i++) {
            if (i + 1 < m)
                shifted[i + 1][0] = grid[i][n - 1];
            for (let j = 0; j < n - 1; j++) {
                shifted[i][j + 1] = grid[i][j];
            }
        }
        shifted[0][0] = grid[m - 1][n - 1];

        for (let i = 0; i < m; i++) 
            for (let j = 0; j < n; j++) 
                grid[i][j] = shifted[i][j];
    }
    return k == 0 ? grid : shifted;
};
// @lc code=end
