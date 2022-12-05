/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num / 2;
        while (right > left) {
            int mid = (left + right) / 2;
            if ((long)mid * mid < (long)num)
                left = mid + 1;
            else
                right = mid;
        }
        return left * left == num;
    }
}
// @lc code=end
