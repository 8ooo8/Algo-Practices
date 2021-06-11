/*
 * @lc app=leetcode id=783 lang=javascript
 *
 * [783] Minimum Distance Between BST Nodes
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var minDiffInBST = function(root) {
    return _DFS(root).filter(v => isFinite(v)).sort((a, b) => a - b).reduce((minDiff, _, i, nodesVal) => {
        return Math.min(minDiff, (nodesVal[i + 1] ?? Number.POSITIVE_INFINITY) - nodesVal[i]);
    }, Number.POSITIVE_INFINITY);
};

const _DFS = (root) => {
    if (!root) return [];
    return [root.val, ..._DFS(root.left), ..._DFS(root.right)];
}
// @lc code=end
