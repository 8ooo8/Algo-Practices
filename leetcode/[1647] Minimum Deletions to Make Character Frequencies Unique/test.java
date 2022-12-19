/*
 * @lc app=leetcode id=1647 lang=java
 *
 * [1647] Minimum Deletions to Make Character Frequencies Unique
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;

class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> letterToFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            letterToFreq.compute(c, (k, v) -> 1 + (v == null ? 0 : v));
        }

        int ans = 0;
        Set<Integer> freq = new HashSet<>();
        for (int f : letterToFreq.values()) {
            int newF = f;
            while (freq.contains(newF) && newF > 0) {
                ans++;
                newF--;
            }
            freq.add(newF);
        }

        return ans;
    }
}
// @lc code=end
