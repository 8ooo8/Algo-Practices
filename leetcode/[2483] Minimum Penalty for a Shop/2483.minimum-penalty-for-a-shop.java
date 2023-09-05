/*
 * @lc app=leetcode id=2483 lang=java
 *
 * [2483] Minimum Penalty for a Shop
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int bestClosingTime(String customers) {
        int minPenalty = 0, curPenalty = 0, res = 0;
        for (int i = 0; i < customers.length(); i++) {
            curPenalty += customers.charAt(i) == 'Y' ? -1 : 1;
            if (curPenalty < minPenalty) {
                minPenalty = curPenalty;
                res = i + 1;
            }
        }
        return res;
    }
}
// @lc code=end
