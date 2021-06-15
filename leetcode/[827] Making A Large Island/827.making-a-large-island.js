/*
 * @lc app=leetcode id=827 lang=javascript
 *
 * [827] Making A Large Island
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var largestIsland = function(grid) {
    grid = grid.map(row => row.map(col => [col])); // turn the primitive values into objects so that they can be shared among the grid slots
    const visited = grid.map(row => Array(row).fill(false));
    const _DFS = (row, col, unionSetRoot) => {
        if (!grid[row]?.[col] || visited[row][col] || grid[row][col][0] === 0)
            return;

        if (!unionSetRoot) {
            unionSetRoot = grid[row][col];
        } else {
            grid[row][col] = unionSetRoot; // every part of a island shares a single unionSetRoot
            unionSetRoot[0]++; // count the number of 1s in this island
        }
        visited[row][col] = true;
        
        _DFS(row - 1, col, unionSetRoot);
        _DFS(row, col - 1, unionSetRoot);
        _DFS(row + 1, col, unionSetRoot);
        _DFS(row, col + 1, unionSetRoot);
    };
    grid.forEach((_, row) => grid.forEach((_, col) => _DFS(row, col)));

    let result = 0;
    let contains0 = false;
    grid.forEach((_, row) => grid.forEach((_, col) => {
        if (grid[row][col][0] === 0) {
            contains0 = true;
            result = Math.max(result,
                [...new Set([grid[row - 1]?.[col], grid[row + 1]?.[col], grid[row][col - 1], grid[row][col + 1]])]
                .reduce((sum, island) => sum += island ? island[0] : 0, 0)
                + 1
            )
        }
    }));
    return contains0 ? result : grid.length * grid.length;
};
// @lc code=end
