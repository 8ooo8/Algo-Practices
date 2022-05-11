/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProducts = new int[nums.length];
        int[] rightProducts = new int[nums.length];
        int[] ans = new int[nums.length];
        leftProducts[0] = 1;
        rightProducts[rightProducts.length - 1] = 1;
        for (int i = 1; i < nums.length; i++)
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        for (int i = nums.length - 2; i >= 0; i--)
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        for (int i = 0; i < nums.length; i++)
            ans[i] = leftProducts[i] * rightProducts[i];
        return ans;
    }
}
// @lc code=end
