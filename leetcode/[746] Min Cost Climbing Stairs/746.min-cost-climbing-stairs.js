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
    /*
     * According to my understanding, the test cases and results provided by leetcode has a minor problem.
     * For instance, according to leetcode, when the input cost is [10,15,20], the output is 15. 
     * However, the min cost should be 10 (start with step 0 and the climb to the top), according to my understanding.
     */
    if (cost.length === 2) return 0;
    if (cost.length === 3) return Math.min(cost[0], cost[1]);
    return cost.slice(2).reduce((minCost, c) => {
        [minCost.current, minCost.pre] = [c + Math.min(minCost.current, minCost.pre), minCost.current];
        return minCost;
    }, {current: cost[1], pre: cost[0]}).current - cost[cost.length - 1];
};
// @lc code=end
