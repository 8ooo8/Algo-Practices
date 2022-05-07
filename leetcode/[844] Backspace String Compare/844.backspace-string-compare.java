/*
 * @lc app=leetcode id=844 lang=java
 *
 * [844] Backspace String Compare
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return getFinalString(s).equals(getFinalString(t));
    }

    private String getFinalString(String s) {
        StringBuilder finalS = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#' && finalS.length() > 0)
                finalS.deleteCharAt(finalS.length() - 1);
            else if (c != '#')
                finalS.append(c);
        }
        return finalS.toString();
    }
}
// @lc code=end
