/*
 * @lc app=leetcode id=897 lang=javascript
 *
 * [897] Increasing Order Search Tree
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
 * @return {TreeNode}
 */
var increasingBST = function(root) {
    const reorderedNodesInArr = _DFS(root);
    const newRoot = new TreeNode(reorderedNodesInArr[0]);
    let lastRoot = newRoot;
    reorderedNodesInArr.slice(1).forEach(nodeVal => {
        lastRoot.right = new TreeNode(nodeVal);
        lastRoot = lastRoot.right;
    });
    return newRoot;
};

const _DFS = (root) => {
    if (!root) return [];
    return [_DFS(root.left), root.val, _DFS(root.right)].flat();
}
// @lc code=end
