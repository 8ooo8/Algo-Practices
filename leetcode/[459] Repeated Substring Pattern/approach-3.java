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
        for (int factor = 1; factor <= s.length() / 2; factor++) 
            if (s.length() % factor == 0 && s.split(s.substring(0, factor)).length == 0)
               return true;
        return false;
    }
}
// @lc code=end
