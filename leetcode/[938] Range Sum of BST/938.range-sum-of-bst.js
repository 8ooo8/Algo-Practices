/*
 * @lc app=leetcode id=938 lang=javascript
 *
 * [938] Range Sum of BST
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
 * @param {number} low
 * @param {number} high
 * @return {number}
 */
var rangeSumBST = function(root, low, high) {
    return _DFS(root, low, high).reduce((sum, num) => sum + num, 0)
};

const _DFS = (root, low, high) => {
    if (!root) return [];
    let leftResult = [], rightResult = [];
    if (root.val >= low) leftResult = _DFS(root.left, low, high);
    if (root.val <= high) rightResult = _DFS(root.right, low, high);
    return [root.val >= low && root.val <= high ? root.val : [], ...leftResult, ...rightResult].flat();
}
// @lc code=end
