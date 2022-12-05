/*
 * @lc app=leetcode id=366 lang=java
 *
 * [366] Find Leaves of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leaves = new ArrayList<>();
        helper(leaves, root);
        return leaves;
    }

    private int helper(List<List<Integer>> leaves, TreeNode node) {
        if (node == null) return -1;

        int lLvl = helper(leaves, node.left);
        int rLvl = helper(leaves, node.right);
        int lvl = Math.max(lLvl, rLvl) + 1;

        if (leaves.size() == lvl) leaves.add(new ArrayList());
        leaves.get(lvl).add(node.val);
        return lvl;
    }
}
// @lc code=end
