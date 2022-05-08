/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
import java.util.Optional;
class Solution {
    public boolean isAnagram(String s, String t) {
        return toMap(s).equals(toMap(t));
    }

    private Map<Character, Integer> toMap(String str) {
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            m.compute(str.charAt(i), (c, occurrence) -> Optional.ofNullable(occurrence).orElse(0) + 1);
        }
        return m;
    }
}
// @lc code=end
