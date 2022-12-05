/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> ans = new PriorityQueue<>((p1, p2) -> getDistance(p2) - getDistance(p1));
        for (int[] p : points) {
            ans.offer(p);
            if (ans.size() > k) {
                ans.poll();
            }
        }
        return ans.stream().toArray(int[][]::new);
    }

    private int getDistance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}
// @lc code=end
