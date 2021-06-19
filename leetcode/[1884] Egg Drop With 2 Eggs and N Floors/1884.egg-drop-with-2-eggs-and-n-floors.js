/*
 * @lc app=leetcode id=1884 lang=javascript
 *
 * [1884] Egg Drop With 2 Eggs and N Floors
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var twoEggDrop = function(n) {
    if (n === 1) return 1;
    const minMovesDP = [3];
    let i = 0;
    while (minMovesDP[i] < n) {
        minMovesDP[i + 1] = minMovesDP[i] + i + 3;
        i++;
    }
    return minMovesDP.length + 1;
};
// @lc code=end
