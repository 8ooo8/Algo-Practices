/*
 * @lc app=leetcode id=263 lang=javascript
 *
 * [263] Ugly Number
 */

// @lc code=start
/**
 * @param {number} n
 * @return {boolean}
 */
var isUgly = function(n) {
    if (n < 1) return false;
    [2, 3, 5].forEach(v => {while (n % v == 0) n /= v});
    return n === 1;
};
// @lc code=end
