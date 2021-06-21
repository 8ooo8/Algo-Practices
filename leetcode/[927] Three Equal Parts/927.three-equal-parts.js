/*
 * @lc app=leetcode id=927 lang=javascript
 *
 * [927] Three Equal Parts
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number[]}
 */
var threeEqualParts = function(arr) {
    const ttlNumOf1s = arr.reduce((count1s, bit) => count1s + bit, 0);
    if (ttlNumOf1s % 3) return [-1, -1];
    if (!ttlNumOf1s) return [0, 2];
    const numOf1sInEachPart = ttlNumOf1s / 3;

    const numOfRight0sInEachPart = (() => {
        let numOfRight0s = 0;
        [...arr].reverse().some((bit) => {
            if (bit) return true;
            numOfRight0s++;
        });
        return numOfRight0s;
    })();
    // Problem: return infinity
    // const getBinaryValue = (from, to) => arr.slice(from, to + 1).reverse().reduce((binaryValue, bit, i) => binaryValue + (bit ? Math.pow(2, i) : 0), 0);
    const getBinaryValue = (from, to) => {
        let result = arr.slice(from, to + 1);
        let numOfLeading0s = 0;
        result.some(bit => {
            if (bit) return true;
            numOfLeading0s++;
        });
        return result.slice(numOfLeading0s).reverse().join('');
    }
    const indicesOf1s = arr.reduce((indices, bit, i) => {
        if (bit) indices.push(i);
        return indices;
    }, []);
    const result = [indicesOf1s[numOf1sInEachPart - 1] + numOfRight0sInEachPart, indicesOf1s[numOf1sInEachPart * 2 - 1] + numOfRight0sInEachPart + 1];
    const part1Value = getBinaryValue(0, result[0]);
    const part2Value = getBinaryValue(result[0] + 1, result[1] - 1);
    const part3Value = getBinaryValue(result[1], arr.length - 1);
    if (part1Value != part2Value || part1Value != part3Value) return [-1, -1];
    return result;
};
// @lc code=end
