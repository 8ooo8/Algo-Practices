/*
 * @lc app=leetcode id=538 lang=java
 *
 * [538] Convert BST to Greater Tree
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
    public TreeNode convertBST(TreeNode root) {
        toGreaterTree(root, 0);
        return root;
    }

    protected int toGreaterTree(TreeNode node, int sumOfKnownGreaterValues) { // return the sum of greater values
        if (node == null) return sumOfKnownGreaterValues;
        node.val += toGreaterTree(node.right, sumOfKnownGreaterValues);
        return toGreaterTree(node.left, node.val);
    }
}
// @lc code=end
