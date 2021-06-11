/*
 * @lc app=leetcode id=1302 lang=javascript
 *
 * [1302] Deepest Leaves Sum
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
var deepestLeavesSum = function(root) {
    return _DFS(root, 0).sum;
};

const _DFS = (root, lvl) => {
    if (!root) return null;
    if (!root.left && !root.right) return {lvl: lvl, sum: root.val};
    return [_DFS(root.left, lvl + 1), _DFS(root.right, lvl + 1)].reduce((result, sum) => {
        if ((sum?.lvl ?? 0) > result.lvl) return sum;
        if ((sum?.lvl ?? 0) < result.lvl) return result;
        result.sum += sum?.sum ?? 0;
        return result;
    }, {lvl: 0, sum: 0});
}
// @lc code=end
