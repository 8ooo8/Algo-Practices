/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    int ans = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            ans++;
            helper(s, i - 1, i + 1);
            helper(s, i, i + 1);
        }
        return ans;
    }

    private void helper(String s, int l, int r) {
        for (; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l--, r++)
            ans++;
    }
}
// @lc code=end
