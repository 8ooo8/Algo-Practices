/*
 * @lc app=leetcode id=997 lang=javascript
 *
 * [997] Find the Town Judge
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number[][]} trust
 * @return {number}
 */
var findJudge = function(n, trust) {
    const trusted = new Array(n).fill(0);
    const doTrust = new Array(n).fill(false);
    for (let i = 0; i < trust.length; i++) {
        let a = trust[i][0], b = trust[i][1];
        trusted[b - 1]++;
        doTrust[a - 1] = true;
    }
    for (let i = 0; i < trusted.length; i++) {
        if (trusted[i] == n - 1 && !doTrust[i]) 
            return i + 1;
    }
    return -1;
};
// @lc code=en<d
