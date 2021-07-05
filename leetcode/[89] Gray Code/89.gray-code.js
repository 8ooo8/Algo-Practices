/*
 * @lc app=leetcode id=89 lang=javascript
 *
 * [89] Gray Code
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number[]}
 */
var grayCode = function(n) {
    const codes = [['0', '1']];
    while (!codes[n - 1]) {
        const lastCodes = codes[codes.length - 1];
        codes[codes.length] = lastCodes.map(v => `0${v}`).concat([...lastCodes].reverse().map(v => `1${v}`));
    };
    return codes[n - 1].map(v => parseInt(v, 2));
};
// @lc code=end
