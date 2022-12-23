/*
 * @lc app=leetcode id=2405 lang=java
 *
 * [2405] Optimal Partition of String
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int partitionString(String s) {
        int ans = 1;
        Set<Character> letters = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (letters.contains(c)) {
                ans++;
                letters.clear();
            }
            letters.add(c);
        }
        return ans;
    }
}
// @lc code=end
