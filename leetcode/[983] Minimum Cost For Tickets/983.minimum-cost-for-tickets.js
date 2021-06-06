/*
 * @lc app=leetcode id=983 lang=javascript
 *
 * [983] Minimum Cost For Tickets
 */

// @lc code=start
/**
 * @param {number[]} days
 * @param {number[]} costs
 * @return {number}
 */
var mincostTickets = function(days, costs) {
    const dp = Array(366).fill(0);
    dp.slice(1, days[days.length - 1] + 1).forEach((minCost, day) => {
        day++;
        if (days.includes(day))
            dp[day] = Math.min(dp[day - 1] + costs[0], (dp[day - 7] || 0) + costs[1], (dp[day - 30] || 0) + costs[2]);
        else
            dp[day] = dp[day - 1];
    });
    return dp[days[days.length - 1]];
};
// @lc code=end
