/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            int lowerTemperatureDay;
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) 
                ans[lowerTemperatureDay = stack.pop()] = i - lowerTemperatureDay;
            stack.push(i);
        }
        return ans;
    }
}
// @lc code=end
