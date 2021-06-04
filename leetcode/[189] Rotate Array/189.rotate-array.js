/*
 * @lc app=leetcode id=189 lang=javascript
 *
 * [189] Rotate Array
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    /*
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    let rotatedCount = 0;
    let lastRotatedNumNewIdx;
    let originalNumAtLastRotatedNumNewIdx;
    let firstRotatedNumIdxInCurrentCycle = 0;
    let isCycleStart = true;
    const getNewIdx = i => (i + k) % nums.length;
    do {
        if (isCycleStart) {
            lastRotatedNumNewIdx = firstRotatedNumIdxInCurrentCycle;
            originalNumAtLastRotatedNumNewIdx = nums[lastRotatedNumNewIdx];
            isCycleStart = false;
        } else if (firstRotatedNumIdxInCurrentCycle === lastRotatedNumNewIdx) {
            firstRotatedNumIdxInCurrentCycle++;
            isCycleStart = true;
            continue;
        }
        const thisRotatedNumNewIdx = getNewIdx(lastRotatedNumNewIdx);
        
        const tmp = nums[thisRotatedNumNewIdx];
        nums[thisRotatedNumNewIdx] = originalNumAtLastRotatedNumNewIdx;
        lastRotatedNumNewIdx = thisRotatedNumNewIdx;
        originalNumAtLastRotatedNumNewIdx = tmp;

        rotatedCount++;
    } while (rotatedCount < nums.length);
};
// @lc code=end
