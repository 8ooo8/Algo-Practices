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
    let accumulatedSum = 0;
    let maxSum = Number.NEGATIVE_INFINITY;
    
    nums.forEach(num => {
        accumulatedSum += num;
        maxSum = Math.max(maxSum, accumulatedSum);
        accumulatedSum = accumulatedSum >= 0 ? accumulatedSum : 0;
    });

    return maxSum;
};
// @lc code=end
