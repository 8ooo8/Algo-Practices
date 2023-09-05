/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    private boolean helper(String s1, int i1, String s2, int i2, String s3, boolean[][] memo) {
        boolean res = i1 == s1.length() && i2 == s2.length();
        if (!res && !memo[i1][i2]) {
            memo[i1][i2] = true;
            if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i1 + i2))
                res |= helper(s1, i1 + 1, s2, i2, s3, memo);
            if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i1 + i2))
                res |= helper(s1, i1, s2, i2 + 1, s3, memo);
        }
        return res;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        return s1.length() + s2.length() == s3.length() && helper(s1, 0, s2, 0, s3, new boolean[s1.length() + 1][s2.length() + 1]);
    }
}
// @lc code=end
