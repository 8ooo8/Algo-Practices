/*
 * @lc app=leetcode id=1092 lang=javascript
 *
 * [1092] Shortest Common Supersequence 
 */

// @lc code=start
/**
 * @param {string} str1
 * @param {string} str2
 * @return {string}
 */

/*
 * Algo:
 *   get the longest common subsequence of the strings and on top of it,
 *   add characters that not yet covered to form the shortest supersequence
 */
var shortestCommonSupersequence = function(str1, str2) {
    const dp = [];

    // compute for the DP table
    [...Array(str1.length + 1).keys()].forEach((i) => { 
        dp[i] = [];
        dp[i][0] = 0;
    });
    [...Array(str2.length + 1).keys()].forEach((i) => dp[0][i] = 0);
    str1.split('').forEach((c1, i1) => {
        i1++;
        str2.split('').forEach((c2, i2) => {
            i2++;
            if (c1 === c2)
                dp[i1][i2] = dp[i1 - 1][i2 - 1] + 1;
            else
                dp[i1][i2] = Math.max(dp[i1 -1][i2], dp[i1][i2 - 1]);
        });
    });

    // form the supersequence
    let result = '';
    let v = 0, nextV;
    let i = str1.length, j = str2.length;
    while (i > 0 && j > 0) {
        v = dp[i][j];
        nextV = dp[i - 1][j]; //try to move left

        if (v !== nextV) {
            nextV = dp[i][j - 1]; //try to move downwards
            if (v === nextV) {
                while (v === nextV && i >= 0 && j >= 0) {
                    j--; //move downwards
                    result = str2[j] + result; // on top of the common subsequnce, add char
                    v = dp[i][j];
                    nextV = dp[i][j - 1]; //try to move downwards
                }
            } else {
                i--, j--; // move left and downwards
                result = str2[j] + result; // add common subsequence char
            }
        } else {
            i--; //move left
            result = str1[i] + result; // on top of the common subsequnce, add char
        }
    }
    if (i > 0)
        result = str1.slice(0, i) + result;
    if (j > 0)
        result = str2.slice(0, j) + result;

    return result;

};
// @lc code=end
