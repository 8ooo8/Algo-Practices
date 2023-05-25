/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
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
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Pair;
import java.lang.*;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> levels = new ArrayDeque<>();
        levels.add(new Pair<>(root, 0));

        int maxWidth = 0;
        while (!levels.isEmpty()) {
            final int numOfNodes = levels.size();
            int firstLocation = levels.peek().getValue(), location = firstLocation;
            for (int i = 0; i < numOfNodes; i++) {
                TreeNode node = levels.peek().getKey();
                location = levels.remove().getValue();
                if (node.left != null)
                    levels.add(new Pair<>(node.left, (location - firstLocation) * 2)); // TLE in extreme case if not "- firstLocation"
                if (node.right != null)
                    levels.add(new Pair<>(node.right, (location - firstLocation) * 2 + 1));
            }
            maxWidth = Math.max(location - firstLocation + 1, maxWidth);
        }
        return maxWidth;
    }
}
// @lc code=end
