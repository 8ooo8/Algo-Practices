/*
 * @lc app=leetcode id=1319 lang=javascript
 *
 * [1319] Number of Operations to Make Network Connected
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number[][]} connections
 * @return {number}
 */
var makeConnected = function(n, connections) {
    if (connections.length < n - 1) return -1;
    const set = Array(n).fill(-1);
    const cyclicEdges = connections.reduce((cyclicEdges, c) => {
        if (isCycle(set, c[0], c[1])) cyclicEdges++;
        else union(set, c[0], c[1]);
        return cyclicEdges;
    }, 0);
    let result = connections.length - cyclicEdges - n + 1;
    return result < 0 ? -result : 0;
};

const findRoot = (set, node) => {
    if (set[node] < 0 || set[node] === node) return node;
    const root = findRoot(set, set[node]);
    set[node] = root; // path compression
    return root;
}
const isCycle = (set, x, y) => {
    if (findRoot(set, x) === findRoot(set, y)) return true;
    return false;
}
const union = (set, x, y) => {
    const xRoot = findRoot(set, x);
    const yRoot = findRoot(set, y);
    if (set[x] < 0 || set[x] === x) set[x] = yRoot;
    else if (set[y] < 0 || set[y] === y) set[y] = xRoot;
    else if (set[xRoot] < 0 || set[xRoot] === xRoot) set[xRoot] = yRoot;
    else set[yRoot] = xRoot;
}

// @lc code=end
