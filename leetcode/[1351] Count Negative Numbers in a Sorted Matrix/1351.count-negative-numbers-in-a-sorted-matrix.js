/*
 * @lc app=leetcode id=1351 lang=javascript
 *
 * [1351] Count Negative Numbers in a Sorted Matrix
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var countNegatives = function(grid) {
    return grid.reduce((negativesCount , numArray) => {
        const firstNegativeNumIdx = _getFirstNegativeNumIdx(numArray);
        if (isNaN(firstNegativeNumIdx))
            return negativesCount;
        return negativesCount + numArray.length - firstNegativeNumIdx;
    }, 0);
};

const _getFirstNegativeNumIdx = (numArray) => {
    const _getResultByBinarySearch = (numArray, from, to) => {
        if (to - from <= 1) {
            if (numArray[from] < 0) return from;
            if (numArray[to] < 0) return to;
            return NaN;
        }
        
        const middle = Math.floor((to - from) / 2) + from;
        if (numArray[middle] < 0)
            return _getResultByBinarySearch(numArray, from, middle);
        return _getResultByBinarySearch(numArray, middle, to);
    }
    return _getResultByBinarySearch(numArray, 0, numArray.length - 1);
}
// @lc code=end
