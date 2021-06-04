/*
 * @lc app=leetcode id=1025 lang=javascript
 *
 * [1025] Divisor Game
 */

// @lc code=start
/**
 * @param {number} n
 * @return {boolean}
 */
var divisorGame = function(n) {
    const aliceWinDpTable = [false, false, true];
    for (let i = 3; i <= n; i++) {
        aliceWinDpTable[i] = _getFactors(i).some(factor => !aliceWinDpTable[i - factor])
    }
    console.log(aliceWinDpTable)
    return aliceWinDpTable[n];
};

const _getFactors = n => {
    let factors = [1];
    if (n != 2 && n % 2 === 0) factors.push(2);
    for (let i = 3; i < n; i += 2) {
        if (n % i === 0) factors.push(i)
    }
    console.log(factors)
    return factors;
}
// @lc code=end
