/*
 * @lc app=leetcode id=236 lang=javascript
 *
 * [236] Lowest Common Ancestor of a Binary Tree
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
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
    const pathToP = _getPathByDFS(root, p.val);
    const pathToQ = _getPathByDFS(root, q.val);
    return pathToP.reduce((commonAncestor, node, i) => node === pathToQ[i] ? node : commonAncestor);
};

const _getPathByDFS = (root, targetValue) => {
    if (!root)
        return null;
    if (root.val === targetValue)
        return [root];

    return [root.left, root.right].reduce((path, node) => {
        let result = _getPathByDFS(node, targetValue);
        result?.unshift(root);
        return result || path;
    }, null);
};
// @lc code=end
