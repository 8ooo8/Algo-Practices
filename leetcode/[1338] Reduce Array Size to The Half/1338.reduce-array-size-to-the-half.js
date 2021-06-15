/*
 * @lc app=leetcode id=1338 lang=javascript
 *
 * [1338] Reduce Array Size to The Half
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number}
 */
var minSetSize = function(arr) {
    arr.sort((a, b) => a - b);
    const duplicatesCounts = [];
    let count = 1;
    for (let i = 1; i < arr.length; i++) {
        if (arr[i] === arr[i - 1]) {
            count++;
        } else {
            duplicatesCounts.push(count);
            count = 1;
        }
    }
    duplicatesCounts.push(count);
    duplicatesCounts.sort((a, b) => -a + b);
    let result = ttlCounts = 0;
    for (let i = 0; i < duplicatesCounts.length; i++) {
        if (ttlCounts >= arr.length / 2) break;
        ttlCounts += duplicatesCounts[i];
        result++;
    }
    return result
};
// @lc code=end
