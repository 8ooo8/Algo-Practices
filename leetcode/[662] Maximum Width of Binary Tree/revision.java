/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;
/*** [vim-leetcode] For Local Syntax Checking ***/

class Solution {
    int maxWidth = 1;

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0, new ArrayList<>());
        return maxWidth;
    }
    
    private void dfs(TreeNode node, int lvl, int i, List<Integer> leftmostNodeIs) {
        if (node == null) return;

        if (leftmostNodeIs.size() <= lvl)
            leftmostNodeIs.add(i);
        else
            maxWidth = Math.max(maxWidth, i - leftmostNodeIs.get(lvl) + 1);
        dfs(node.left, lvl + 1, 2 * i, leftmostNodeIs);
        dfs(node.right, lvl + 1, 2 * i + 1, leftmostNodeIs);
    }
}
// @lc code=end
