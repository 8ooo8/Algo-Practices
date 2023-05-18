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
        int minFlips = 0;
        int numOf1s = 0;
        for (char c : s.toCharArray()) {
            if (c == '0')
                minFlips = Math.min(numOf1s, minFlips + 1); // either flip all 1s before or flip this 0 to 1
            else
                numOf1s++;
        }
        return minFlips;
    }
}
// @lc code=end
