/*
 * @lc app=leetcode id=473 lang=javascript
 *
 * [473] Matchsticks to Square
 */

// @lc code=start
/**
 * @param {number[]} matchsticks
 * @return {boolean}
 */
var makesquare = function(matchsticks) {
    matchsticks.sort((a, b) => -a + b); // reduce running time
    const sideLength = matchsticks.reduce((sumLength, length) => sumLength + length) / 4;
    const DFS = (i, s1, s2, s3, s4) => {
        // if ([s1, s2, s3, s4].some(s => s > sideLength)) return false; //array creation is an expensive overhead
        if (s1 > sideLength || s2 > sideLength || s3 > sideLength || s4 > sideLength) return false;
        if (i > matchsticks.length - 1) return [s1, s2, s3, s4].every(s => s === sideLength);
        const len = matchsticks[i];
        return DFS(i + 1, s1 + len, s2, s3, s4)
            || DFS(i + 1, s1, s2 + len, s3, s4)
            || DFS(i + 1, s1, s2, s3 + len, s4)
            || DFS(i + 1, s1, s2, s3, s4 + len);
    }
    return DFS(0, 0, 0, 0, 0);
};
// @lc code=end
