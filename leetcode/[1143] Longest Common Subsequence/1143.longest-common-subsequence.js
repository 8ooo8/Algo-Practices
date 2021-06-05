/*
 * @lc app=leetcode id=1143 lang=javascript
 *
 * [1143] Longest Common Subsequence
 */

// @lc code=start
/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function(text1, text2) {
    const dp = [];
    [...Array(text1.length + 1).keys()].forEach((i) => { 
        dp[i] = [];
        dp[i][0] = 0;
    });
    [...Array(text2.length + 1).keys()].forEach((i) => dp[0][i] = 0);
    text1.split('').forEach((c1, i1) => {
        i1++;
        text2.split('').forEach((c2, i2) => {
            i2++;
            if (c1 === c2)
                dp[i1][i2] = dp[i1 - 1][i2 - 1] + 1;
            else
                dp[i1][i2] = Math.max(dp[i1 -1][i2], dp[i1][i2 - 1]);
        });
    });
    return dp[text1.length][text2.length];
};
// @lc code=end
