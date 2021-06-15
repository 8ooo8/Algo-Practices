/*
 * @lc app=leetcode id=515 lang=javascript
 *
 * [515] Find Largest Value in Each Tree Row
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
 * @return {number[]}
 */
var largestValues = function(root) {
    if (!root) return [];

    const maxValues = [];
    let maxValue = NaN;
    let handlingLvl = 0;
    const queue = [{node: root, lvl: 1}];
    while (queue.length > 0) {
        const node = queue[0];
        queue.shift();
        if (node.lvl > handlingLvl) {
            if (!isNaN(maxValue))
                maxValues.push(maxValue);
            maxValue = node.node.val;
            handlingLvl++;
        } else {
            maxValue = Math.max(maxValue, node.node.val);
        }
        if (node.node.left) queue.push({node: node.node.left, lvl: node.lvl + 1});
        if (node.node.right) queue.push({node: node.node.right, lvl: node.lvl + 1});
    }
    return maxValues.concat(maxValue);
};
// @lc code=end
