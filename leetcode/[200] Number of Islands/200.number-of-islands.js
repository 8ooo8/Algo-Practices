/*
 * @lc app=leetcode id=200 lang=javascript
 *
 * [200] Number of Islands
 */

// @lc code=start
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    const visited = grid.map(_ => Array(grid[0].length).fill(false));
    const DFS = (i, j) => {
        if (visited[i]?.[j] || grid[i]?.[j] === undefined || grid[i][j] === '0') return;
        visited[i][j] = true;
        DFS(i - 1, j);
        DFS(i + 1, j);
        DFS(i, j - 1);
        DFS(i, j + 1);
    }
    let islands = 0;
    grid.forEach((_, i) => grid[i].forEach((_, j) => {
        if (grid[i][j] === '1' && !visited[i][j]) {
            DFS(i, j);
            islands++;
        }
    }));
    return islands;
};
// @lc code=end
