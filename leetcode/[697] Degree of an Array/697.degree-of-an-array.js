/*
 * @lc app=leetcode id=697 lang=javascript
 *
 * [697] Degree of an Array
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findShortestSubArray = function(nums) {
    const occurenceCounts = {};
    nums.forEach((num, i) => {
        if (occurenceCounts[num] === undefined) {
            occurenceCounts[num] = {count: 1, minIdx: i, maxIdx: i};
        } else {
            occurenceCounts[num].count++;
            occurenceCounts[num].maxIdx = i;
        }
    });
    const mostCount = Object.values(occurenceCounts).reduce((mostCount, count) => {
        if (count.count < mostCount.count)
            return mostCount;
        if (count.count === mostCount.count && count.maxIdx - count.minIdx > mostCount.maxIdx - mostCount.minIdx)
            return mostCount;
        return count;
    }, {count: 0});
    return mostCount.maxIdx - mostCount.minIdx + 1;
};
// @lc code=end
