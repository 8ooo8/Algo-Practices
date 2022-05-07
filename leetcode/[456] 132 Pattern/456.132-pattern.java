/*
 * @lc app=leetcode id=456 lang=java
 *
 * [456] 132 Pattern
 */

// @lc code=start
class Solution {
    public boolean find132pattern(int[] nums) {
        int second = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (second > nums[i])
                return true;
            while (!stack.isEmpty() && nums[i] > stack.peek()) 
                second = stack.pop();
            stack.push(nums[i]);
        }
        return false;
    }
}
// @lc code=end
