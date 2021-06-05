/*
 * @lc app=leetcode id=392 lang=javascript
 *
 * [392] Is Subsequence
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence = function(s, t) {
    let sCursor = 0;
    t.split('').forEach(tChar => { if (tChar === s[sCursor]) sCursor++ });
    if (sCursor >= s.length) return true;
    return false
};
// @lc code=end
