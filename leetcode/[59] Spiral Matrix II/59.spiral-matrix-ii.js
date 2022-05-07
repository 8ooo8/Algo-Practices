/*
 * @lc app=leetcode id=59 lang=javascript
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number[][]}
 */
var generateMatrix = function(n) {
    const spiralDirs = [[0,1], [1, 0], [0,-1], [-1,0]];
    let currentDir = 0;

    const result = [...Array(n)].map(e => Array(n));
    const visited = [...Array(n)].map(e => Array(n).fill(false));
    let i = 0, j = 0;
    const getNextIJ = (i, j) => [i + spiralDirs[currentDir][0], j + spiralDirs[currentDir][1]];
    const tryChangeDir = () => {
        let [newI, newJ] = getNextIJ(i, j);
        if (newI >= n || newI < 0 || newJ >= n || newJ < 0 || visited[newI][newJ])
            currentDir = (currentDir + 1) % 4;
    };

    for (let p = 1; p <= n*n; p++) {
        result[i][j] = p;
        visited[i][j] = true;
        tryChangeDir();
        [i, j] = getNextIJ(i, j);
    }

    return result;
};
// @lc code=end
