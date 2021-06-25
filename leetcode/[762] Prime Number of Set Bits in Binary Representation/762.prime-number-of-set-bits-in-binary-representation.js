/*
 * @lc app=leetcode id=762 lang=javascript
 *
 * [762] Prime Number of Set Bits in Binary Representation
 */

// @lc code=start
/**
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
var countPrimeSetBits = function(left, right) {
    const allSetBits = {};
    for (let i = left; i <= right; i++) {
        const numOfSetBits = i.toString(2).split('').map(Number).filter(v => v).length;
        allSetBits[numOfSetBits] = (allSetBits[numOfSetBits] ?? 0) + 1;
    }
    return Object.keys(allSetBits).reduce((count, setBits) => {
        if (parseInt(setBits) === 2) return count + allSetBits[setBits];
        if (parseInt(setBits) % 2 === 0 || parseInt(setBits) < 2) return count;
        for (let i = 3; i < parseInt(setBits) / 2; i += 2) {
            if (parseInt(setBits) % i === 0) return count;
        }
        return count + allSetBits[setBits];
    }, 0);
};
// @lc code=end
