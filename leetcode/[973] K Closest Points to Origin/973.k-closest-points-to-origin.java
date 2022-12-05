/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (p1, p2) -> getDistance(p1) - getDistance(p2));
        return Arrays.copyOf(points, k);
    }

    private int getDistance(int[] p) {
        return p[0] * p [0] + p[1] * p[1];
    }
}
// @lc code=end
