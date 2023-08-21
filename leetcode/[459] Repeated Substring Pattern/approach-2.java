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

            String toRepeat = s.substring(0, factor);
            StringBuilder repeated = new StringBuilder(toRepeat);
            for (int i = factor; i < s.length(); i += factor)
                repeated.append(toRepeat);
            if (repeated.toString().equals(s))
                return true;
        }
        return false;
    }
}
// @lc code=end
