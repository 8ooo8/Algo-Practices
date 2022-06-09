/*
 * @lc app=leetcode id=828 lang=java
 *
 * [828] Count Unique Characters of All Substrings of a Given String
 */

// @lc code=start
class Solution {
    public int uniqueLetterString(String s) {
        int[] charContributions = new int['Z' + 1]; // 'Z' instead of 26 to avoid the calculation of "x - 'A'"
        int[] charLastPosition = new int['Z' + 1];
        Arrays.fill(charLastPosition, 'A', 'Z' + 1, -1);
        int ans = 0, contributionSum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            contributionSum -= charContributions[c];
            contributionSum += (charContributions[c] = i - charLastPosition[c]);
            charLastPosition[c] = i;
            ans += contributionSum;
        }
        return ans;
    }
}
// @lc code=end
