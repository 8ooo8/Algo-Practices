/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int i;
        for (i = 0; i < nums.length; i++)
            if (m.compute(nums[i], (num, occurrences) -> (occurrences ==  null ? 0 : occurrences) + 1) > nums.length / 2) break;
        return nums[i];
    }
}
// @lc code=end
