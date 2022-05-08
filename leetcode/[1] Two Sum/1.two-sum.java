/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(target - nums[i]))
                return new int[]{i, m.get(target - nums[i])};
            m.put(nums[i], i);
        }
        return null;
    }
}
// @lc code=end
