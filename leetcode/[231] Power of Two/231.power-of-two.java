/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long nl = (long)n;
        return (nl & (nl - 1)) == 0;
    }
}
// @lc code=end
