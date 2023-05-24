/*
 * @lc app=leetcode id=2486 lang=java
 *
 * [2486] Append Characters to String to Make Subsequence
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int appendCharacters(String s, String t) {
         if (s.contains(t)) return 0;

        int T = t.length(), i = 0;
        char[] tChars = t.toCharArray();
        for (char c : s.toCharArray())
            if (c == tChars[i])
                if (++i == T)
                    return 0;
        return T - i;
    }
}
// @lc code=end
