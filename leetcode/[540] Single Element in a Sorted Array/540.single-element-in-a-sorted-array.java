/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int left = 0, right = nums.length / 2 - 1;
        while (right > left) {
            int mid = (right + left) / 2;
            if (nums[mid * 2] == nums[mid * 2 + 1])
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left * 2] == nums[left * 2 + 1] ? nums[nums.length - 1] : nums[left * 2];
    }
}
// @lc code=end
