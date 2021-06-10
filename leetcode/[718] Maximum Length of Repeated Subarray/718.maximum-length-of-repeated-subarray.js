/*
 * @lc app=leetcode id=718 lang=javascript
 *
 * [718] Maximum Length of Repeated Subarray
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findLength = function(nums1, nums2) {
    const dp = nums2.map(_ => []);
    nums2.forEach((num2, i) => {
        nums1.forEach((num1, j) => {
            if (num1 !== num2) return;
            dp[i][j] = (dp[i - 1]?.[j - 1] ?? 0) + 1;
        })
    })
    return dp.map(v => v.reduce((maxArrLen, arrLen) => Math.max(maxArrLen, arrLen), 0))
        .reduce((maxArrLen, arrLen) => Math.max(maxArrLen, arrLen), 0)
};
// @lc code=end
