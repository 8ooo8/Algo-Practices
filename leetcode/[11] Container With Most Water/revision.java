/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int l = 0, r = height.length - 1; r > l;) {
            maxArea = Math.max(Math.min(height[l], height[r]) * (r - l), maxArea);
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }
}
// @lc code=end
