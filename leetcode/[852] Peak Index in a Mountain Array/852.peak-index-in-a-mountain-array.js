/*
 * @lc app=leetcode id=852 lang=javascript
 *
 * [852] Peak Index in a Mountain Array
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number}
 */
var peakIndexInMountainArray = function(arr) {
    return _getPeakIdx(arr);
};

const _getPeakIdx = (arr) => {
    const isMountain = (i) => !(arr[i-1] > arr[i] || arr[i+1] > arr[i]);
    const getResultByBinarySearch = (arr, from, to) => {
        if (to - from <= 1) {
            if (isMountain(from)) return from;
            return to;
        }

        const middle = Math.floor((to - from) / 2) + from;
        if (arr[middle + 1] > arr[middle])
            return getResultByBinarySearch(arr, middle, to);
        return getResultByBinarySearch(arr, from, middle);
    }
    return getResultByBinarySearch(arr, 0, arr.length - 1);
}
// @lc code=end
