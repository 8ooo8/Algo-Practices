/*
 * @lc app=leetcode id=547 lang=javascript
 *
 * [547] Number of Provinces
 */

// @lc code=start
/**
 * @param {number[][]} isConnected
 * @return {number}
 */
var findCircleNum = function(isConnected) {
    const visited = Array(isConnected.length).fill(false);
    let provinces = 0;
    const _DFS = (i) => {
        visited[i] = true;
        isConnected[i].forEach((connected, j) => {
            if (!connected || visited[j]) return;
            _DFS(j);
        });
    };
    visited.forEach((v, i) => {
        if (v) return;
        _DFS(i);
        provinces++;
    });
    return provinces;
};
// @lc code=end
