/*
 * @lc app=leetcode id=968 lang=java
 *
 * [968] Binary Tree Cameras
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
    int ans = 0;

    public int minCameraCover(TreeNode root) {
        if ((helper(root) & 0b001) > 0)
            ans++;
        return ans;
    }

    /*
     * 0b100 means the child node has camera
     * 0b010 means the child node doesn't have camera but being covered
     * 0b001 means the child node is not being covered
     */
    private int helper(TreeNode node) {
        if (node == null)
            return 0b010;
        int childState = helper(node.left) | helper(node.right);
        if ((childState & 0b001) > 0) {
            ans++; // place a camera here if got at least one child not being covered
            return 0b100;
        }
        return (childState & 0b100) > 0 ? 0b010 : 0b001;
    }
}
// @lc code=end
