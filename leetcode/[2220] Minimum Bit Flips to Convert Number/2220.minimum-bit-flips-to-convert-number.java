/*
 * @lc app=leetcode id=2220 lang=java
 *
 * [2220] Minimum Bit Flips to Convert Number
 */

// @lc code=start
class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = 0, toFlip = start ^ goal;
        while (toFlip > 0) {
            ans += toFlip & 1;
            toFlip >>= 1;
        }
        return ans;
    }
}
// @lc code=end
