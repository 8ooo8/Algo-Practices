/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int factor = 1; factor <= s.length() / 2; factor++) {
            if (s.length() % factor > 0) continue;

            boolean foundPattern = true;
            String sub = s.substring(0, factor);
            for (int i = 1; i < s.length() / factor; i++)
                if (!sub.equals(s.substring(i * factor, (i + 1) * factor))) {
                    foundPattern = false;
                    break;
                }
            if (foundPattern) return true;
        }
        return false;
    }
}
// @lc code=end
