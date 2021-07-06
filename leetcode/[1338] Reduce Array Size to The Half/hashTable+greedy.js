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
    let occurences = {};
    arr.forEach(num => occurences[num] = (occurences[num] || 0) + 1);
    occurences = Object.values(occurences).sort((a, b) => -a + b);
    let ttlOccurences = 0;
    let result = 0;
    for (let i = 0; ttlOccurences < arr.length / 2; i++) {
        ttlOccurences += occurences[i];
        result++;
    }
    return result;
};
// @lc code=end
