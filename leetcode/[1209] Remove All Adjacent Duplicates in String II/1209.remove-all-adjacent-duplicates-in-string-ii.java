// @algorithm @lc id=1209 lang=java
// @title remove-all-adjacent-duplicates-in-string-ii
/*
 * @lc app=leetcode id=1209 lang=java
 *
 * [1209] Remove All Adjacent Duplicates in String II
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s, int k) {
        char[] cArr = s.toCharArray();
        char[] ans = new char[s.length()];

        int ansCursor = 0;
        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            ans[ansCursor] = c;
            while (removable(ans, ansCursor, k)) {
                ansCursor -= k;
            }
            ansCursor++;
        }

        return String.copyValueOf(ans, 0, ansCursor);
    }

    private boolean removable(char[] ans, int ansCursor, int k) {
        return ansCursor >= k - 1 && IntStream.range(ansCursor - k + 1, ansCursor).allMatch(i -> ans[i] == ans[ansCursor]);
    }
}
// @lc code=end
