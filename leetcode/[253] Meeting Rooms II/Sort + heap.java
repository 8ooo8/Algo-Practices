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

        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        Queue<Integer> end = new PriorityQueue<>();
        int minRooms = 1;
        for (int[] i : intervals) {
            while (!end.isEmpty() && end.peek() <= i[0]) { // assumed that no extra room needed when the start time and end time of 2 different rooms are the same
                end.remove();
            }
            minRooms = Math.max(minRooms, 1 + end.size());
            end.offer(i[1]);
        }
        return minRooms;
    }
}
// @lc code=end
