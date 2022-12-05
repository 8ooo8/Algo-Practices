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
    private boolean findLeaves(TreeNode node, List<Integer> leaves) {
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return true;
        }
        if (node.left != null && findLeaves(node.left, leaves))
            node.left = null;
        if (node.right != null && findLeaves(node.right, leaves))
            node.right = null;
        return false;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        while (!(root.left == null && root.right == null)) {
            List<Integer> leaves = new ArrayList<>();
            findLeaves(root, leaves);
            ans.add(leaves);
        }
        ans.add(Arrays.asList(root.val));
        return ans;
    }
}
// @lc code=end
