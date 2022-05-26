/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 */

// @lc code=start
public class Solution {
    private static int[] bits = new int[32];
    static {
        for (int i = 0; i < bits.length; i++)
            bits[i] = 1 << i;
    }
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        for (int bit : bits)
            if ((bit & n) != 0) ans++;
        return ans;
    }
}
// @lc code=end
// 11111111111111111111111111111101
// 10000000000000000000000000000000
