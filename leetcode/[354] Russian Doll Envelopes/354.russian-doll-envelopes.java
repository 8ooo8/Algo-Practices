/*
 * @lc app=leetcode id=354 lang=java
 *
 * [354] Russian Doll Envelopes
 */

// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (e1, e2) -> e1[0] != e2[0] ? e1[0] - e2[0] : e2[1] - e1[1]); // width in ascending order, height in descending order
        int[] dp = new int[envelopes.length];
        int dpLen = 0;
        for (int[] e : envelopes) {
            int i = Arrays.binarySearch(dp, 0, dpLen, e[1]);
            if (i < 0) i = -i - 1;
            dp[i] = e[1];
            if (i == dpLen) dpLen++;
        }
        return dpLen;
    }
}
// @lc code=end
