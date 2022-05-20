/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int trapped = 0;
        while (right > left) {
            if (height[left] < height[right]) {
                int trappedWaterHeight = height[left], waterToAdd;
                while (right > left && (waterToAdd = trappedWaterHeight - height[++left]) > 0)
                    trapped += waterToAdd;
            } else {
                int trappedWaterHeight = height[right], waterToAdd;
                while (right > left && (waterToAdd = trappedWaterHeight - height[--right]) > 0)
                    trapped += waterToAdd;
            }
        }
        return trapped;
    }
}
// @lc code=end
