/*
 * @lc app=leetcode id=1512 lang=javascript
 *
 * [1512] Number of Good Pairs
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var numIdenticalPairs = function(nums) {
    return Object.values(_getOccurenceCounts(nums)).reduce((result, count) => result + count * (count - 1) / 2, 0);
};

const _getOccurenceCounts = nums => {
    let counts = {};
    nums.forEach(num => {
        counts[num] = counts[num] || 0;
        counts[num]++;
    });
    console.log(counts)
    return counts;
}
// @lc code=end
