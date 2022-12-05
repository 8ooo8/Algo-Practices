/*
 * @lc app=leetcode id=2214 lang=java
 *
 * [2214] Minimum Health to Beat Game
 */

// @lc code=start
class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 0;
        int max = Integer.MIN_VALUE;
        for (int d : damage) {
            sum += d;
            max = Math.max(max, d);
        }
        return sum - Math.min(armor, max) + 1;
    }
}
// @lc code=end)
