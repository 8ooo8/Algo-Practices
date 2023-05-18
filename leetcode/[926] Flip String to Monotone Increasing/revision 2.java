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
        int numOf0s = (int)s.chars().filter(digit -> digit == '0').count();
        int minFlips = numOf0s; // the flips required to make all 1s
        int flips = minFlips;
        for (char digit : s.toCharArray())
            minFlips = Math.min(minFlips, (flips += digit == '0' ? -1 : 1));
        return minFlips;
    }
}
// @lc code=end
