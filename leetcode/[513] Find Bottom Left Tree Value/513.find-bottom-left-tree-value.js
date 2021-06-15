/*
 * @lc app=leetcode id=513 lang=javascript
 *
 * [513] Find Bottom Left Tree Value
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
var findBottomLeftValue = function(root) {
    let bottomLeftNode = {node: root, lvl: 1};
    const queue = [bottomLeftNode];
    while (queue.length > 0) {
        const node = queue[0];
        queue.shift();
        if (node.node.left) queue.push({node: node.node.left, lvl: node.lvl + 1});
        if (node.node.right) queue.push({node: node.node.right, lvl: node.lvl + 1});
        if (node.lvl > bottomLeftNode.lvl) bottomLeftNode = node;
    }
    return bottomLeftNode.node.val;
};
// @lc code=end
