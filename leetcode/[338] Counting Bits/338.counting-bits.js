/*
 * @lc app=leetcode id=338 lang=javascript
 *
 * [338] Counting Bits
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number[]}
 */
var countBits = function(n) {
    if (n == 0) 
        return [0];

    const result = [0, 1];
    let _soFarLargestBinaryDigitValue = 1;
    const _getLargestBinaryDigitValue = decimal => {
        if (decimal >= _soFarLargestBinaryDigitValue * 2)
            _soFarLargestBinaryDigitValue *= 2;
        return _soFarLargestBinaryDigitValue;
    }
    
    for (let i = 2; i <= n; i++) {
        result.push(1 + result[i - _getLargestBinaryDigitValue(i)])
    }

    return result;
};
// @lc code=end
