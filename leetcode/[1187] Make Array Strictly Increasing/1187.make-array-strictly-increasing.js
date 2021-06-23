/*
 * @lc app=leetcode id=1187 lang=javascript
 *
 * [1187] Make Array Strictly Increasing
 */

// @lc code=start
/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number}
 */
var makeArrayIncreasing = function(arr1, arr2) {
    const dp = Array(arr1.length + 1).fill().map(_ => []);
    const updateDp = (i, j, newValue) => dp[i][j] = (dp[i][j]?.rightNum ?? Number.POSITIVE_INFINITY) > newValue.rightNum ? newValue : dp[i][j];
    arr2.sort((a, b) => a - b);
    dp[0][0] = {rightNum: Number.NEGATIVE_INFINITY, iAtArr2: 0};
    let numOfOps = [0];
    for (let i = 1, pre = dp[i - 1], arr1C = arr1[i - 1] ; i < dp.length; i++, pre = dp[i - 1], arr1C = arr1[i - 1]) {
        let newNumOfOps = [];
        let minRightNum = Number.POSITIVE_INFINITY;
        numOfOps.forEach(numOfOp => {
            let {rightNum, iAtArr2} = pre[numOfOp];
            if (arr1C > rightNum) {
                updateDp(i, numOfOp, {rightNum: arr1C, iAtArr2: iAtArr2});
                if (newNumOfOps.length === 0 || newNumOfOps[newNumOfOps.length - 1] !== numOfOp && arr1C < minRightNum) newNumOfOps.push(numOfOp);
                minRightNum = Math.min(minRightNum, arr1C);
            }
            for (let j = iAtArr2; j < arr2.length; j++) {
                if (arr2[j] > rightNum) {
                    updateDp(i, numOfOp + 1, {rightNum: arr2[j], iAtArr2: j + 1});
                    if (newNumOfOps.length === 0 || newNumOfOps[newNumOfOps.length - 1] !== numOfOp + 1 && arr2[j] < minRightNum) newNumOfOps.push(numOfOp + 1);
                    minRightNum = Math.min(minRightNum, arr2[j]);
                    break;
                }
            }
        });
        numOfOps = newNumOfOps;
    }
    return numOfOps[0] ?? -1;
};
// @lc code=end
