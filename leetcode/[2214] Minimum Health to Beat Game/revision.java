/*
 * @lc app=leetcode id=2214 lang=java
 *
 * [2214] Minimum Health to Beat Game
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public long minimumHealth(int[] damage, int armor) {
        int maxDmg = damage[0];
        long ret = 0;
        for (int d : damage) {
            ret += d;
            maxDmg = Math.max(d, maxDmg);
        }

        return ret + 1 - Math.min(armor, maxDmg);
    }
}
// @lc code=end
