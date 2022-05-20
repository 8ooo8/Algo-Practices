/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        for (char replacement = 'A'; replacement <= 'Z'; ++replacement) {
            int from = -1, to = 0, replaced = 0; // exclusive from, inclusive to
            for (; to < s.length(); ++to) {
                if (s.charAt(to) != replacement) {
                    if (replaced < k)
                        ++replaced;
                    else {
                        do {
                            ++from;
                        } while (from <= to && s.charAt(from) == replacement);
                    }
                }
                ans = Math.max(ans, to - from);
            }
        }
        return ans;
    }
}
// @lc code=end
