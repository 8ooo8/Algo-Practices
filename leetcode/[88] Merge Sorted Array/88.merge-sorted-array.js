/*
 * @lc app=leetcode id=88 lang=javascript
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    let merged = Array(m + n);
    let p = 0, i = 0, j = 0;
    for (; i < m && j < n; p++) {
        if (nums1[i] < nums2[j]) {
            merged[p] = nums1[i];
            i++;
        } else {
            merged[p] = nums2[j];
            j++;
        }
    }
    if (i < m)
        for (; i < m; i++, p++)
            merged[p] = nums1[i];
    if (j < n)
        for (; j < n; j++, p++)
            merged[p] = nums2[j];
    for (let q = 0; q < m + n; q++)
        nums1[q] = merged[q];
};
// @lc code=end
