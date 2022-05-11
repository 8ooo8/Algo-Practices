/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
import java.lang.StringBuilder;
class Solution {
    public boolean isPalindrome(String s) {
        String processedS = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        return processedS.equals(new StringBuilder(processedS).reverse().toString());
    }
}
// @lc code=end
