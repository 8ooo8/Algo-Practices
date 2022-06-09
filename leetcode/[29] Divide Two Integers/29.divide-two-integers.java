/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */

// @lc code=start
public class Solution {
    public int divide(int dividend, int divisor) {
        int absDividend = Math.abs(dividend), absDivisor = Math.abs(divisor);
        int ans = 0, divisorBitShift;
        do {
            divisorBitShift = helper(absDividend, absDivisor);
            if (divisorBitShift >= 0) {
                ans += 1 << divisorBitShift;
                absDividend -= absDivisor << divisorBitShift;
            }
        } while (divisorBitShift >= 0);
        boolean sameSigns = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        if (ans < 0) return sameSigns ? Integer.MAX_VALUE : Integer.MIN_VALUE; // handle overflow
        return sameSigns ? ans : -ans;
    }
    
    private int helper(int absDividend, int absDivisor) {
        int divisorBitShift = -1;
        while (absDividend - (absDivisor << (divisorBitShift + 1)) >= 0 && divisorBitShift < 32) divisorBitShift++;
        return divisorBitShift;
    }
}
// @lc code=end
