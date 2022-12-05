/*
 * @lc app=leetcode id=2096 lang=java
 *
 * [2096] Step-By-Step Directions From a Binary Tree Node to Another
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
    private boolean find(TreeNode root, int target, StringBuilder instructions) {
        if (root == null)
            return false;
        if (root.val == target)
            return true;
        if (find(root.left, target, instructions))
            instructions.append('L');
        else if (find(root.right, target, instructions))
            instructions.append('R');
        return instructions.length() > 0;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s = new StringBuilder(), d = new StringBuilder();
        find(root, startValue, s);
        find(root, destValue, d);
        // System.out.println(s.toString() + ", " + d.toString());
        int i = 0, maxI = Math.min(s.length(), d.length());
        while (i < maxI && s.charAt(s.length() - i - 1) == d.charAt(d.length() - i - 1))
            i++;
        return "U".repeat(s.length() - i) + d.reverse().substring(i);

    }
}
// @lc code=end
