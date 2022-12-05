/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int left = 0, right = 0;
        boolean[][] isPalindrome = new boolean[s.length()][s.length()]; // DP table
        for (int i = 0; i < isPalindrome.length; i++) {
            isPalindrome[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i == j + 1 || isPalindrome[i - 1][j + 1])) {
                    isPalindrome[i][j] = true;
                    if (i - j > right - left) {
                        left = j;
                        right = i;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
// @lc code=end
