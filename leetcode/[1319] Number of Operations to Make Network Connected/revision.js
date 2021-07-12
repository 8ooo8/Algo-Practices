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
    const disjointSet = Array(n).fill(-1);
    let numOfCycles = 0;
    connections.forEach(([a, b]) => {
        if (_formingCycle(disjointSet, a, b)) {
            numOfCycles++;
        } else {
            _union(disjointSet, a, b);
        }
    });
    const numOfUnconnected = disjointSet.filter(v => v < 0).length - 1;
    return numOfUnconnected ? (numOfCycles >= numOfUnconnected ? numOfUnconnected : -1) : 0;
};

const _findRoot = (set, a) => {
    if (set[a] < 0) return a;
    const root = _findRoot(set, set[a]);
    set[a] = root; //path compression
    return root;
};

const _formingCycle = (set, a, b) => {
    return _findRoot(set, a) === _findRoot(set, b);
}

const _union = (set, a, b) => {
    const aRoot = _findRoot(set, a);
    const bRoot = _findRoot(set, b);
    if (aRoot !== bRoot) {
        set[aRoot] = bRoot;
    }
};

// @lc code=end
