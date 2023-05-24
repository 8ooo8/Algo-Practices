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
        int i, j;
        for (i = 0, j = 0; i < s.length() && j < t.length(); i++)
            if (s.charAt(i) == t.charAt(j)) j++;
        return t.length() - j;
    }
}
// @lc code=end
