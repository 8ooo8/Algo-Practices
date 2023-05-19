/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        
        int N = intervals.length;

        int[] start = new int[N];
        int[] end = new int[N];
        for (int i = 0; i < N; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int minRooms = 1;
        for (int startClock = 0, endClock = 0; startClock < N; startClock++) {
            while (start[startClock] >= end[endClock])
                endClock++;
            minRooms = Math.max(minRooms, 1 + startClock - endClock);
        }
        return minRooms;
    }
}
// @lc code=end
