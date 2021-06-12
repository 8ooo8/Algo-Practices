/*
 * @lc app=leetcode id=264 lang=javascript
 *
 * [264] Ugly Number II
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var nthUglyNumber = function(n) {
    const dp = [0, 0, 0];
    const multi = [2, 3, 5];
    const uglyNums = [1];
    for (let thUgly = 1; thUgly < n; thUgly++) {
        const minI = multi.slice(0, 2).reduce((minI, _, i) => {
            iMultiResult = uglyNums[dp[i]] * multi[i];
            minIMultiResult = uglyNums[dp[minI[0]]] * multi[minI[0]];
            if (iMultiResult === minIMultiResult)
                minI.push(i);
            if (iMultiResult < minIMultiResult)
                minI = [i];
            return minI;
        }, [2]);

        uglyNums.push(uglyNums[dp[minI[0]]] * multi[minI[0]]);
        minI.forEach(i => dp[i]++);
    }
    return uglyNums[uglyNums.length - 1];
};

// TLE
// var nthUglyNumber = function(n) {
    // const dp = [false, true];
    // let i = 1, j = 2;
    // for (; i < n; j++) {
        // [2, 3, 5].some(factor => {
            // if (j % factor === 0 && dp[j / factor]) {
                // i++;
                // return dp[j] = true;
            // }
        // })
    // }
    // return j - 1;
// };
// @lc code=end
