/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charLocations = new HashMap<>();
        int res = 0;
        for (int from = 0, to = 0; to < s.length(); to++) {
            from = Math.max(from, charLocations.getOrDefault(s.charAt(to), 0));
            res = Math.max(res, to - from + 1);
            charLocations.put(s.charAt(to), to + 1);
        }
        return res;
    }
}
// @lc code=end
