/*
 * @lc app=leetcode id=1365 lang=javascript
 *
 * [1365] How Many Numbers Are Smaller Than the Current Number
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var smallerNumbersThanCurrent = function(nums) {
    const occurenceCounts = Object.entries(_getOccurenceCounts(nums)).map(([k, v]) => {return {num: k, count: v}});
    const sortedCounts = [...occurenceCounts].sort((count1, count2) => count1.num - count2.num); // sort by nums element (not count); in ascending order
    let countsSum = 0;
    const smallerNumCounts = sortedCounts.map((count, i) => {return {num: count.num, count: countsSum += sortedCounts[i - 1]?.count || 0}});
    const smallerNumCountsInObj = smallerNumCounts.reduce((counts, count) => {
        counts[count.num] = count.count;
        return counts;
    }, {});
    return nums.map(num => smallerNumCountsInObj[num]);
};

const _getOccurenceCounts = nums => {
    let counts = {};
    nums.forEach(num => {
        counts[num] = counts[num] || 0;
        counts[num]++;
    })
    return counts;
}
// @lc code=end
