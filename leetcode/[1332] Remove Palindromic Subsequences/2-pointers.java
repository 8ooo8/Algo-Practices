/*
 * @lc app=leetcode id=1332 lang=java
 *
 * [1332] Remove Palindromic Subsequences
 */

// @lc code=start
class Solution {
    public int removePalindromeSub(String s) {
        return isPalindrome(s) ? 1 : 2;
    }

    private boolean isPalindrome(String s) {
        int lo = -1, hi = s.length();
        while (--hi > ++lo) {
            if (s.charAt(lo) != s.charAt(hi))
                return false;
        }
        return true;
    }
}
// @lc code=end
