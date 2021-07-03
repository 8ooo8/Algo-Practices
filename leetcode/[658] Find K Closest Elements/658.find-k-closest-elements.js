/*
 * @lc app=leetcode id=658 lang=javascript
 *
 * [658] Find K Closest Elements
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @param {number} k
 * @param {number} x
 * @return {number[]}
 */
var findClosestElements = function(arr, k, x) {
    const closestNumIndex = _getClosestNumIndex(x, arr);
    let l = closestNumIndex - k - 1, r = closestNumIndex + k + 1;
    l = l >= 0 ? l : 0, r = r < arr.length ? r : arr.length - 1;
    while (r - l + 1 > k) {
        if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x))
            r--;
        else
            l++;
    };
    return arr.slice(l, r + 1);
};

const _getClosestNumIndex = (x, arr) => {
    const bs = (l, r) => {
        if (r - l <= 1) return l;

        const mid = l + Math.floor((r - l) / 2);
        if (arr[mid] > x) return bs(l, mid);
        return bs(mid, r);
    }
    return bs(0, arr.length - 1);
}
// @lc code=end
