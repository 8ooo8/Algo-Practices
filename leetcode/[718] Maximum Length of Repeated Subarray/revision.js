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
    const dp = nums1.map(_ => []);
    for (let i = 0; i < nums1.length; i++) {
        for (let j = 0; j < nums2.length; j++) {
            dp[i][j] = nums1[i] === nums2[j] ? (dp[i - 1]?.[j - 1] ?? 0) + 1 : 0;
        }
    }
    return dp.flat().reduce((maxLen, len) => Math.max(maxLen, len));
};
// @lc code=end
