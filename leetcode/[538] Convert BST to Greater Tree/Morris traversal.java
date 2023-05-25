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

/*
 * This is a solution from the editorial.
 * Check https://leetcode.com/playground/QroJknPr/shared for more explanation.
 * */

class Solution {
    /* Get the node with the smallest value greater than this one. */
    private TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }

    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;

        while (node != null) {
            /* 
             * If there is no right subtree, then we can visit this node and
             * continue traversing left.
             */
            if (node.right == null) { // when no unvisited node with greater value (the nodes like parent should have been already visited); following reverse in-order
                sum += node.val; // do the work here when no node with greater value
                node.val = sum;
                node = node.left; // back to its ancestor, i.e. the node with the largest value that is smaller than its value
            }
            /* 
             * If there is a right subtree, then there is at least one node that
             * has a greater value than the current one. therefore, we must
             * traverse that subtree first.
             */
            else {
                TreeNode succ = getSuccessor(node); // get the node that has the smallest value greater than this one
                /* 
                 * If the left subtree is null, then we have never been here before.
                 */
                if (succ.left == null) { // keep linking the nodes while moving `node` to point to the greater node
                    succ.left = node;
                    node = node.right;
                }
                /* 
                 * If there is a left subtree, it is a link that we created on a
                 * previous pass, so we should unlink it and visit this node.
                 */
                else { // revisit a node (`node` (at the same time link to its successor) -> ... -> the successor of `node` -> `node`)
                    succ.left = null; // remove the temporary linkage
                    sum += node.val; // do the work here as its right subtree is finished
                    node.val = sum;
                    /*
                     * case 1:
                     *   the parent of `node` gets a right subtree which is `node` and `node` doesn't have its left subtree
                     *   -> a temproray successor linkage between `node` and its parenet, `node.left`, is made
                     *   -> `node = node.left` bringing us back to the parent of `node`
                     * case 2:
                     *   `node` gets a left subtree, and the sccessor of its parent resides in the left subtree
                     *   -> `node = node.left` bringing us to the left subtree,
                     *       and it will in the end going back to the parent of `node` via the successor linkage
                     * case 3:
                     *   `node` is the root
                     */
                    node = node.left;
                }
            }
        }
        
        return root;
    }
}
// @lc code=end
