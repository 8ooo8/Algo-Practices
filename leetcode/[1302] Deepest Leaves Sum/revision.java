/*
 * @lc app=leetcode id=1302 lang=java
 *
 * [1302] Deepest Leaves Sum
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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        while (!q.isEmpty()) {
            sum = 0;
            int thisLvlNumOfLeaves = q.size();
            for (int i = 0; i < thisLvlNumOfLeaves; i++) {
                TreeNode n = q.poll();
                sum += n.val;
                if (n.left != null) 
                    q.offer(n.left);
                if (n.right != null) 
                    q.offer(n.right);
            }
        }
        return sum;
    }
}
// @lc code=end
