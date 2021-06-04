/*
 * @lc app=leetcode id=1748 lang=javascript
 *
 * [1748] Sum of Unique Elements
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var sumOfUnique = function(nums) {
    return _getAllUniqueNums(nums).reduce((sum, num) => sum + num, 0);
};

const _getAllUniqueNums = nums => {
    let occurenceCounts = {};
    nums.forEach(num => occurenceCounts[num] = occurenceCounts[num] + 1 || 1);
    return Object.entries(occurenceCounts).filter(([num, count]) => count == 1).map(([num, count]) => num).map(Number);
}
// @lc code=end
