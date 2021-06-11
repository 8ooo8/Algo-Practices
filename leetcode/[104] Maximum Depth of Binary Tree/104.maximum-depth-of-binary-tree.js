/*
 * @lc app=leetcode id=104 lang=javascript
 *
 * [104] Maximum Depth of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function(root) {
    return _DFS(root);
};

const _DFS = (root) => {
    if (!root) return 0;
    return Math.max(_DFS(root.left), _DFS(root.right)) + 1;
}
// @lc code=end
