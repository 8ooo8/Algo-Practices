/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        while (!q.isEmpty()) {
            Queue<Integer> largestValuesInCurrentDepth = new PriorityQueue<>(q.size(), Collections.reverseOrder());
            int numOfNodesInCurrentDepth = q.size();
            for (int i = 0; i < numOfNodesInCurrentDepth; i++) {
                if (q.peek() != null) {
                    TreeNode n = q.peek();
                    largestValuesInCurrentDepth.offer(n.val);
                    q.offer(n.left);
                    q.offer(n.right);
                }
                q.poll();
            }
            if (largestValuesInCurrentDepth.peek() != null)
                ans.add(largestValuesInCurrentDepth.poll());
        }

        return ans;
    }
}
// @lc code=end
