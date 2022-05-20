/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0;
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        for (int from = 0, to = 0; to < s.length(); to++) {
            if (lastOccurrence.containsKey(s.charAt(to)) && lastOccurrence.get(s.charAt(to)) >= from)
                from = lastOccurrence.get(s.charAt(to)) + 1;
            longestLength = Math.max(longestLength, to - from + 1);
            lastOccurrence.put(s.charAt(to), to);
        }
        return longestLength;
    }
}
// @lc code=end
