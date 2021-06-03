/*
 * @lc app=leetcode id=33 lang=javascript
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    const numsSlices = _sliceAtPivot(nums);
    const targetIdx = numsSlices.map(slice => _getTargetIdxByBinarySearch(slice, target, 0, slice.length - 1));
    if (targetIdx.filter(i => i >= 0).length == 0) return -1;
    return targetIdx[0] >= 0 ? targetIdx[0] : numsSlices[0].length + targetIdx[1];
};

/*
 * e.g. an rotated nums: [4,5,6,7,0,1,2]
 * divide it into [4,5,6,7] and [0,1,2] and return them
 */
const _sliceAtPivot = (nums) => {
    const sliceByBinarySearch = (nums, from, to) => {
        // base case
        if (to - from <= 1)
            return [nums.slice(0, to), nums.slice(to, nums.length)];

        // search recursively
        const shouldSearchRight = currentNum => currentNum > nums[0];
        const middle = Math.floor((to - from) / 2) + from;
        if (shouldSearchRight(nums[middle]))
            return sliceByBinarySearch(nums, middle, to);
        return sliceByBinarySearch(nums, from, middle);
    };

    if (nums.length > 1)
        return sliceByBinarySearch(nums, 0, nums.length - 1);
    return [nums];
};

const _getTargetIdxByBinarySearch = (nums, target, from, to) => {
    // base case
    if (to - from <= 1) {
        if (nums[from] === target) 
            return from;
        if (nums[to] === target)
            return to;
        return -1;
    }

    // search recursively
    const middle = Math.floor((to - from) / 2) + from;
    if (nums[middle] <= target)
        return _getTargetIdxByBinarySearch(nums, target, middle, to);
    return _getTargetIdxByBinarySearch(nums, target, from, middle);
}
// @lc code=end
