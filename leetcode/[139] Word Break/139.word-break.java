/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        final int SL = s.length();
        boolean[] memo = new boolean[SL + 1];
        memo[0] = true;
        
        for (int i = 0; i < SL; i++) {
            for (String word : wordDict)
                if (memo[i] && SL - i >= word.length() && s.substring(i, i + word.length()).equals(word))
                    memo[i + word.length()] = true;
        }

        return memo[SL];
    }
}
// @lc code=end
