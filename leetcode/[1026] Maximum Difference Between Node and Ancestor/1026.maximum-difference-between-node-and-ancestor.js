/*
 * @lc app=leetcode id=1026 lang=javascript
 *
 * [1026] Maximum Difference Between Node and Ancestor
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
var maxAncestorDiff = function(root) {
    let maxDiff = Number.NEGATIVE_INFINITY;
    const DFS = (root) => {
        if (!root) return {max: Number.NEGATIVE_INFINITY, min: Number.POSITIVE_INFINITY};
        if (!root.left && !root.right) return {max: root.val, min: root.val};
        const maxAndMinValues = DFS(root.right);
        const maxAndMinValues2 = DFS(root.left);
        const [max, min] = [Math.max(maxAndMinValues.max, maxAndMinValues2.max), Math.min(maxAndMinValues.min, maxAndMinValues2.min)];
        maxDiff = Math.max(maxDiff, Math.abs(root.val - max), Math.abs(root.val - min));
        return {max: Math.max(root.val, max), min: Math.min(root.val, min)};
    }
    DFS(root);
    return maxDiff;
};
// @lc code=end
