/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Queue<int[]> earliest = new PriorityQueue<>(intervals.length, (i1, i2) -> i1[0] - i2[0]);
        for (int[] i : intervals)
            earliest.add(i);

        List<int[]> ret = new ArrayList<>();
        int[] merged = earliest.remove();
        while (!earliest.isEmpty()) {
            int[] toMerge = earliest.remove();
            if (toMerge[0] <= merged[1]) {
                merged[1] = Math.max(toMerge[1], merged[1]);
            } else {
                ret.add(merged);
                merged = toMerge;
            }
        }
        ret.add(merged);

        return ret.toArray(int[][]::new);
    }
}
// @lc code=end
