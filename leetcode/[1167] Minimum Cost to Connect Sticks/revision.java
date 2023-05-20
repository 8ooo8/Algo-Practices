/*
 * @lc app=leetcode id=1167 lang=java
 *
 * [1167] Minimum Cost to Connect Sticks
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int connectSticks(int[] sticks) {
        Queue<Integer> minLengths = new PriorityQueue<>();
        for (int length : sticks)
            minLengths.add(length);

        int ttlCost = 0, cost;
        while (minLengths.size() > 1) {
            minLengths.add(cost = minLengths.remove() + minLengths.remove()); // heap rather than sort here, becoz the size of the connected sticks should be placed in order as well
            ttlCost += cost;
        }

        return ttlCost;
    }
}
// @lc code=end
