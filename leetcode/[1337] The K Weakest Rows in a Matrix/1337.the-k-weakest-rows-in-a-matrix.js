/*
 * @lc app=leetcode id=1337 lang=javascript
 *
 * [1337] The K Weakest Rows in a Matrix
 */

// @lc code=start
/**
 * @param {number[][]} mat
 * @param {number} k
 * @return {number[]}
 */
var kWeakestRows = function(mat, k) {
    const solidersNums = mat.map((row, i) => {return {i: i, num: _getSolidersNum(row)}});
    solidersNums.sort((num1, num2) => num1['num'] === num2['num'] ? num1['i'] - num2['i'] : num1['num'] - num2['num']);
    return solidersNums.slice(0, k).map(num => num['i']);
};

const _getSolidersNum = (row) => {
    const getResultByBinarySearch = (row, from, to) => {
        if (to - from <= 1) {
            if (row[to] === 1)
                return to + 1;
            if (row[from] === 1)
                return from + 1;
            return 0;
        }

        const middle = Math.floor((to - from) / 2) + from;
        if (row[middle] === 1)
            return getResultByBinarySearch(row, middle, to);
        return getResultByBinarySearch(row, from, middle);
    }

    return getResultByBinarySearch(row, 0, row.length - 1);
};
// @lc code=end
