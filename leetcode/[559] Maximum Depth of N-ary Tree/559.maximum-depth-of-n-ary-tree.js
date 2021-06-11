/*
 * @lc app=leetcode id=559 lang=javascript
 *
 * [559] Maximum Depth of N-ary Tree
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {Node|null} root
 * @return {number}
 */
var maxDepth = function(root) {
    return _DFS(root);
};

const _DFS = (root) => {
    if (!root) return 0;
    return root.children.reduce((maxDepth, child) => Math.max(maxDepth, _DFS(child)), 0) + 1;
}
// @lc code=end
