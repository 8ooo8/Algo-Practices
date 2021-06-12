/*
 * @lc app=leetcode id=202 lang=javascript
 *
 * [202] Happy Number
 */

// @lc code=start
/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
    const squares = Array(10).fill().map((_, i) => Math.pow(i, 2));
    const visited = [];
    const getDigitSquareSum = n => n.toString(10).split('').reduce((sum, digit) => sum + squares[digit], 0);

    let sum = n;
    do {
        sum = getDigitSquareSum(sum);
        if (visited[sum]) return false; // return false when ends in an endless loop
        visited[sum] = true;
    } while (sum !== 1);
    return true;
};
// @lc code=end
