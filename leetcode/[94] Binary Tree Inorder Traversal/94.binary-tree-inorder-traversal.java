/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> roots = new Stack<>();
        TreeNode lastRoot = root;
        while (lastRoot != null || !roots.isEmpty()) {
            while (lastRoot != null) {
                roots.push(lastRoot);
                lastRoot = lastRoot.left;
            }
            lastRoot = roots.pop();
            ans.add(lastRoot.val);
            lastRoot = lastRoot.right;
        }
        return ans;
    }
}
// @lc code=end
