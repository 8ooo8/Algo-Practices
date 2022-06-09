/*
 * @lc app=leetcode id=1332 lang=java
 *
 * [1332] Remove Palindromic Subsequences
 */

// @lc code=start
class Solution {
    public int removePalindromeSub(String s) {
        return new StringBuilder(s).reverse().toString().equals(s) ? 1 : 2;
    }
}
// @lc code=end
