/*
 * @lc app=leetcode id=746 lang=javascript
 *
 * [746] Min Cost Climbing Stairs
 */

// @lc code=start
/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
    if (cost.length === 2) return Math.min(cost[0], cost[1]);
    const last2StepsMinCost = cost.slice(2).reduce((minCost, c) => {
        [minCost.current, minCost.pre] = [c + Math.min(minCost.current, minCost.pre), minCost.current];
        return minCost;
    }, {current: cost[1], pre: cost[0]});
    return Math.min(last2StepsMinCost.current, last2StepsMinCost.pre);
};
// @lc code=end
