/*
 * @lc app=leetcode id=679 lang=javascript
 *
 * [679] 24 Game
 */

// @lc code=start
/**
 * @param {number[]} cards
 * @return {boolean}
 */
var judgePoint24 = function(cards) {
    return _DFS(cards)
};

const _DFS = (nums) => {
    if (nums.length === 2) {
        return _getCalcResults(nums[0], nums[1]).some(r => Math.abs(r - 24) <= 10e-14);
    }
    return nums.some((_, i) => nums.some((_, j) => {
        if (i >= j) return false;
        return _getCalcResults(nums[i], nums[j]).some(r => {
            const numClone = JSON.parse(JSON.stringify(nums));
            numClone.splice(i, 1);
            numClone.splice(i > j ? j : j - 1, 1);
            numClone.push(r);
            return _DFS(numClone);
        })
    }));
}

const _getCalcResults = (a, b) => [a + b, a - b, b - a, a * b, a / b, b / a];
// @lc code=end
