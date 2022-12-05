/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = Stream.of(intervals).mapToInt(i -> i[0]).sorted().toArray();
        int[] end = Stream.of(intervals).mapToInt(i -> i[1]).sorted().toArray();
        int ans = 0;
        int requiredRooms = 0;
        for (int sI = 0, eI = 0; sI < start.length; sI++) {
            while (end[eI] <= start[sI]) {
                eI++;
                requiredRooms--;
            }
            ans = Math.max(ans, ++requiredRooms);
        }
        return ans;
    }
}
// @lc code=end
