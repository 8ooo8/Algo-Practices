/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> occurred = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (occurred.containsKey(target - nums[i]))
                return new int[]{occurred.get(target - nums[i]), i};
            occurred.put(nums[i], i);
        }
        return null;
    }
}
// @lc code=end
