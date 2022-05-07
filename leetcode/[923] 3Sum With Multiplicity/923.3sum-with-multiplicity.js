/*
 * @lc app=leetcode id=923 lang=javascript
 *
 * [923] 3Sum With Multiplicity
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @param {number} target
 * @return {number}
 */
var threeSumMulti = function(arr, target) {
    let ans = 0;
    let map = [];
    for (let i = 0; i < arr.length; i++) {
        ans = (ans + (map[target - arr[i]] ?? 0)) % 1000000007;
        for (let j = 0; j < i; j++) {
            map[arr[i] + arr[j]] = (map[arr[i] + arr[j]] ?? 0) + 1;
        }
    }
    return ans;
};
// @lc code=end
