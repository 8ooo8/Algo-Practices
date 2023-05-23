/*
 * @lc app=leetcode id=545 lang=java
 *
 * [545] Boundary of Binary Tree
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

class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ret = new ArrayList<>(Arrays.asList(root.val));
        getLeftBound(root.left, true, ret);
        getRightBound(root.right, true, ret);
        return ret;
    }
    
    // preorder traversal
    protected void getLeftBound(TreeNode node, boolean isInLeftBound, List<Integer> ret) {
        if (node == null) return;

        if ((node.left == null && node.right == null) || isInLeftBound)
            ret.add(node.val);
        getLeftBound(node.left, isInLeftBound, ret);
        getLeftBound(node.right, isInLeftBound && node.left == null, ret);
    }

    // postorder traversal
    protected void getRightBound(TreeNode node, boolean isInRightBound, List<Integer> ret) {
        if (node == null) return;

        getRightBound(node.left, isInRightBound && node.right == null, ret);
        getRightBound(node.right, isInRightBound, ret);
        if ((node.left == null && node.right == null) || isInRightBound)
            ret.add(node.val);
    }
}
// @lc code=end
