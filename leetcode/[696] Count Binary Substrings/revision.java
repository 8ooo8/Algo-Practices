/*
 * @lc app=leetcode id=696 lang=java
 *
 * [696] Count Binary Substrings
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int countBinarySubstrings(String s) {
        int pre = 0, cur = 1, ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                cur++;
            else {
                ans += Math.min(pre, cur);
                pre = cur;
                cur = 1;
            }
        }
        return ans += Math.min(pre, cur);
    }
}
// @lc code=end
