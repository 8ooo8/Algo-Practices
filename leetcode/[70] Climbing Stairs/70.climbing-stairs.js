/*
 * @lc app=leetcode id=70 lang=javascript
 *
 * [70] Climbing Stairs
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    if (n === 1) return 1;
    if (n === 2) return 2;
    return Array.apply(null, Array(n - 3)).reduce((dp, i) => {
        [dp.current, dp.pre, dp.prepre] = [dp.current + dp.pre, dp.current, dp.pre];
        return dp;
    }, {current: 3, pre: 2, prepre: 1}).current;
};
// @lc code=end
