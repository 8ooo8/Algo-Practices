/*
 * @lc app=leetcode id=11 lang=javascript
 *
 * [11] Container With Most Water
 */

// @lc code=start
/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    const getArea = (p1, p2) => Math.min(height[p1], height[p2]) * (p2 - p1);
    let p1 = 0, p2 = height.length - 1;   
    let maxArea = 0;
    while (p2 > p1)
    {
        maxArea = Math.max(maxArea, getArea(p1, p2));
        if (height[p1] > height[p2])
            p2--;
        else
            p1++;
    }
    return maxArea;
};
// @lc code=end
