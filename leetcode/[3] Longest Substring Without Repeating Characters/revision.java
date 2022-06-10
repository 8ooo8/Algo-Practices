/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] lastOccurred = new int[129];
        char rC;
        for (int right = 0, left = 0; right < s.length(); right++) {
            if (lastOccurred[(rC = s.charAt(right))] > left)
                left = lastOccurred[rC];
            lastOccurred[rC] = right + 1;
            ans = Math.max(right - left + 1, ans);
        }
        return ans;
    }
}
// @lc code=end
