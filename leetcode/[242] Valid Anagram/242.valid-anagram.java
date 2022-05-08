/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        return getSorted(s).equals(getSorted(t));
    }
    
    private String getSorted(String str) {
        char[] cArr = str.toCharArray();
        Arrays.sort(cArr);
        return String.copyValueOf(cArr);
    }
}
// @lc code=end
