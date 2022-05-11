/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder processedS = new StringBuilder();
        String lowerCaseS = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char c = lowerCaseS.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))
                processedS.append(c);
        }
        for (int l = 0, r = processedS.length() - 1; r > l; l++, r--)
            if (processedS.charAt(l) != processedS.charAt(r))
                return false;
        return true;
    }
}
// @lc code=end
