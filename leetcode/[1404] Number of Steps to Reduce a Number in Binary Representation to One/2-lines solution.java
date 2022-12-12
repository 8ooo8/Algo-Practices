/*
 * @lc app=leetcode id=1404 lang=java
 *
 * [1404] Number of Steps to Reduce a Number in Binary Representation to One
 */

// @lc code=start
class Solution {
    public int numSteps(String s) {
        int numOf1s = (int)s.chars().filter(c -> c == '1').count();
        return numOf1s == 1 ? s.length() - 1 : s.length() - 2 * s.indexOf('1') + s.lastIndexOf('1') - numOf1s + 2;
    }
}
// @lc code=end
