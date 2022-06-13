/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 */

// @lc code=start
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] s1Parts = s1.split(" ", 2);
            String[] s2Parts = s2.split(" ", 2);

            boolean s1IsDigits = Character.isDigit(s1Parts[1].charAt(0));
            boolean s2IsDigits = Character.isDigit(s2Parts[1].charAt(0));

            if (s1IsDigits && s2IsDigits)
                return 0;
            if (s1IsDigits || s2IsDigits)
                return s1IsDigits ? 1 : -1;

            int contentCmp = s1Parts[1].compareTo(s2Parts[1]);
            return contentCmp == 0 ? s1Parts[0].compareTo(s2Parts[0]) : contentCmp;
        });
        return logs;
    }
}
// @lc code=end
