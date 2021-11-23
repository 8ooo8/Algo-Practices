/*
 * @lc app=leetcode id=598 lang=java
 *
 * [598] Range Addition II
 */

// @lc code=start
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minX = Arrays.stream(ops)
                        .reduce(m, (a, b) -> Math.min(a, b[0]), (a, b) -> Math.min(a, b));
        int minY = Arrays.stream(ops)
                        .reduce(n, (a, b) -> Math.min(a, b[1]), (a, b) -> Math.min(a, b));
        return minX * minY;
    }
}
// @lc code=end
