/*
 * @lc app=leetcode id=696 lang=java
 *
 * [696] Count Binary Substrings
 */

// @lc code=start
class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        int[] counts = new int[2];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int bit = c - '0', opposing = (bit + 1) % 2;
            counts[bit] = i > 0 && s.charAt(i - 1) != c ? 1 : counts[bit] + 1;
            if (counts[bit] <= counts[opposing])
                ans++;
        }
        return ans;
    }
}
// @lc code=end
