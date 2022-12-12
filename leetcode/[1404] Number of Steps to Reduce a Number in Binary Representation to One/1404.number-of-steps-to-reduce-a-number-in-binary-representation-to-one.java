/*
 * @lc app=leetcode id=1404 lang=java
 *
 * [1404] Number of Steps to Reduce a Number in Binary Representation to One
 */

// @lc code=start
class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int first1 = s.indexOf('1');
        int carry = 0;
        for (int i = s.length() - 1; i > first1; i--) {
            if (carry + s.charAt(i) - '0' == 1) {
                steps++;
                carry = 1;
            }
            steps++;
        }
        return steps + carry;
    }
}
// @lc code=end
