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
import java.util.Map.Entry;
import java.lang.*;
public class TreeNode {
int val;
TreeNode left;
TreeNode right;
TreeNode() {}
TreeNode(int val) { this.val = val; }
TreeNode(int val, TreeNode left, TreeNode right) {
this.val = val;
this.left = left;
this.right = right;
}
}

class Solution {
    int maxWidth = 1;

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, new HashMap<>(), 1, 0);
        return maxWidth;
    }

    protected void dfs(TreeNode node, Map<Integer, Integer> leftmostNodes, int level, int i){
        if (node == null) return;

        leftmostNodes.putIfAbsent(level, i);
        maxWidth = Math.max(i - leftmostNodes.get(level) + 1, maxWidth);
        dfs(node.left, leftmostNodes, level + 1, i * 2);
        dfs(node.right, leftmostNodes, level + 1, i * 2 + 1);
    }
}
// @lc code=end
