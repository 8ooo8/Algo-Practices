/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 */

// @lc code=start
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1Delimiter = s1.indexOf(' ');
                int s2Delimiter = s2.indexOf(' ');

                boolean s2IsDigits = s2.charAt(s2Delimiter + 1) <= '9';
                if (s1.charAt(s1Delimiter + 1) <= '9')
                    return s2IsDigits ? 0 : 1;
                if (s2IsDigits)
                    return -1;

                int contentCmp = s1.substring(s1Delimiter + 1).compareTo(s2.substring(s2Delimiter + 1));
                return contentCmp == 0 ? s1.substring(0, s1Delimiter).compareTo(s2.substring(0, s2Delimiter)) : contentCmp;
            }
        };
        Arrays.sort(logs, cmp);
        return logs;
    }
}
// @lc code=end
