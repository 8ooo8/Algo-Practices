/*
 * @lc app=leetcode id=907 lang=java
 *
 * [907] Sum of Subarray Minimums
 */

// @lc code=start
class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<int[]> mins = new Stack<>(); // [0] for min value, [1] for the corresponding leftmost index
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int lastMinIndex = i;
            while (!mins.isEmpty() && mins.peek()[0] > arr[i]) {
                sum -= (mins.peek()[0]  - arr[i]) * (lastMinIndex - (lastMinIndex = mins.pop()[1]));
            }
            mins.push(new int[]{arr[i], lastMinIndex});
            ans = (ans + sum) % (1000_000_000 + 7);
        }
        return ans;
    }
}
// @lc code=end
