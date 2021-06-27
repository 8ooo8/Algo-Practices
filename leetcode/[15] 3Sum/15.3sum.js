/*
 * @lc app=leetcode id=15 lang=javascript
 *
 * [15] 3Sum
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */

// Time: O(n^2)
var threeSum = function(nums) {
    const result = [];

    const hasNums = Array(200_001);
    nums.forEach(num => hasNums[num + 100_001] = true);
    const hasNum = (num) => hasNums[num + 100_001];

    const sortedNums = [];
    [...nums].sort((a, b) => a - b).forEach((num, i) => {
        if (sortedNums.length && sortedNums[sortedNums.length - 1].num === num)
            sortedNums[sortedNums.length - 1].count++;
        else
            sortedNums.push({num: num, count: 1});
    });

    for (let i = 0; i < sortedNums.length; i++) {
        for (let j = i; j < sortedNums.length; j++) {
            const twoSum = sortedNums[i].num + sortedNums[j].num;
            if (hasNum(-twoSum)) {
                let numIAmount = 1 + (i === j) + (sortedNums[i].num === -twoSum);
                let numJAmount = 1 + (sortedNums[j].num === -twoSum);
                if (sortedNums[i].count >= numIAmount && sortedNums[j].count >= numJAmount && sortedNums[j].num <= -twoSum)
                    result.push([sortedNums[i].num, sortedNums[j].num, -twoSum]);
            }
        }
    }
    
    return result;
};
// @lc code=end

