/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 */

// @lc code=start
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Stream<String> letters = Arrays.stream(logs).filter(s -> s.split(" ")[1].charAt(0) > '9');
        Stream<String> digits = Arrays.stream(logs).filter(s -> s.split(" ")[1].charAt(0) <= '9');
        letters = letters.sorted((s1, s2) -> {
            String s1Id = s1.substring(0, s1.indexOf(' ')), s1Content = s1.substring(s1.indexOf(' ') + 1);
            String s2Id = s2.substring(0, s2.indexOf(' ')), s2Content = s2.substring(s2.indexOf(' ') + 1);
            int contentComparison = s1Content.compareTo(s2Content);
            return contentComparison == 0 ? s1Id.compareTo(s2Id) : contentComparison;
        });
        return Stream.concat(letters, digits).toArray(String[]::new);
    }
}
// @lc code=end
