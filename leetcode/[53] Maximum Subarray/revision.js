/*
 * @lc app=leetcode id=53 lang=javascript
 *
 * [53] Maximum Subarray
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    let maxSum = nums[0], sum = nums[0];

    for (let i = 1; i < nums.length; i++) {
        sum = nums[i] + (sum > 0 ? sum : 0);
        maxSum = Math.max(sum, maxSum);
    }

    return maxSum;
};
// @lc code=end
