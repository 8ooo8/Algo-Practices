/*
 * @lc app=leetcode id=1641 lang=javascript
 *
 * [1641] Count Sorted Vowel Strings
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var countVowelStrings = function(n) {
    let dp = Array(5).fill(1);
    Array(n - 1).fill().forEach(_ => dp.forEach((_, i) => Array(i + 1).fill().forEach((_, j) => dp[j] += i === j ? 0 : dp[i])));
    return dp.reduce((result, strCount) => result += strCount);
};
// @lc code=end
