/*
 * @lc app=leetcode id=561 lang=javascript
 *
 * [561] Array Partition I
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var arrayPairSum = function(nums) {
    /*
     * Algo: 
     *  Optimal solution:
     *      1) let the sorted nums be {n1, n2, ...}, where ni < nj for j > i
     *      2) form pairs with the next n, i.e. (n1, n2), (n3, n4), ...
     */
    return nums.sort((num1, num2) => num1 - num2).filter((num, i) => i % 2 == 0).reduce((sum, num) => sum + num, 0);
};
// @lc code=end
