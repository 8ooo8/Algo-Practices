/*
 * @lc app=leetcode id=5 lang=javascript
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    /*
     * dp[0]: the length of the longest palindrome with center at 1st element
     * dp[1]: the length of the longest palindrome with center sits between 1st & 2nd element
     * dp[2]: the length of the longest palindrome with center at 2nd elemnent
     * ...
     */
    const dp = Array.apply(null, Array(s.length * 2 - 1));
    dp.forEach((v, i) => dp[i] = i % 2 ? 0 : 1);
    s.split('').forEach((c, i) => {
        // find the current/previous char same as c
        const matches = s.substring(0, i + 1).split('').reduce((matches, _c, j) => {
            if (c === _c)
                matches.push(j);
            return matches;
        }, []);

        // check if the matches may form a new/longer palindrome
        matches.forEach(j => {
            const palindromeCenter = ((i - j + 1) / 2 + j) * 2 - 1;

            if (palindromeCenter % 2) {
                // when the center point stands between s's elements
                dp[palindromeCenter] += (i - (palindromeCenter - 1) / 2) * 2 === dp[palindromeCenter] + 2 ? 2 : 0;
            } else {
                // when the center point stands on a s's element
                dp[palindromeCenter] += (i - palindromeCenter / 2) * 2 + 1 === dp[palindromeCenter] + 2 ? 2 : 0;
            }
        });
    });

    return dp.reduce((maxPalindrome, palindromeLength, i) => {
        if (maxPalindrome.length >= palindromeLength) return maxPalindrome;
        if (i % 2) return s.substring((i - 1) / 2 - palindromeLength / 2 + 1, (i + 1) / 2 + palindromeLength / 2);
        return s.substring((i / 2) - (palindromeLength - 1) / 2, (i / 2) + (palindromeLength + 1) / 2);
    }, '');
};
// @lc code=end
