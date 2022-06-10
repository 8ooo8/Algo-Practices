/*
 * @lc app=leetcode id=476 lang=java
 *
 * [476] Number Complement
 */

// @lc code=start
class Solution {
    public int findComplement(int num) {
        int msb = 0;
        while (num >> msb > 1)
            msb++;
        return (int)(((1L << (msb + 1)) - 1) ^ num);
    }
}
// @lc code=end
