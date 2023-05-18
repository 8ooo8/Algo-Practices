/*
 * @lc app=leetcode id=926 lang=java
 *
 * [926] Flip String to Monotone Increasing
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int minFlipsMonoIncr(String s) {
        int N = s.length();
        int[] countOf0s = new int[N];
        for (int i = 0; i < N; i++) {
            countOf0s[i] = (i > 0 ? countOf0s[i - 1] : 0) + (s.charAt(i) == '0' ? 1 : 0);
        }

        int ttl0s = countOf0s[N - 1];
        int minFlips = ttl0s; // the flips required to make all 1s
        for (int i = 0; i < N; i++) {
            minFlips = Math.min(minFlips, i + 1 - countOf0s[i] + (ttl0s - countOf0s[i]));
        }
        return minFlips;
    }
}
// @lc code=end
