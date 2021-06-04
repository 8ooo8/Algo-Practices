/*
 * @lc app=leetcode id=1460 lang=javascript
 *
 * [1460] Make Two Arrays Equal by Reversing Sub-arrays
 */

// @lc code=start
/**
 * @param {number[]} target
 * @param {number[]} arr
 * @return {boolean}
 */
var canBeEqual = function(target, arr) {
    if (target.length != arr.length) return false;
    arr.sort();
    return target.sort().every((num, i) => num == arr[i]);
};
// @lc code=end
