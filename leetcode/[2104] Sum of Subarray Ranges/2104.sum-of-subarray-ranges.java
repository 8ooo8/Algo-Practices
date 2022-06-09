/*
 * @lc app=leetcode id=2104 lang=java
 *
 * [2104] Sum of Subarray Ranges
 */

// @lc code=start
class Solution {
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        int n = nums.length;
        Stack<Integer> peaks = new Stack<>();

        // min
        for (int i = 0; i <= n; i++) {
            while (!peaks.isEmpty() && nums[peaks.peek()] > (i == n ? Integer.MIN_VALUE : nums[i])) {
                int prevMinI = peaks.pop();
                int prevprevMinI = peaks.isEmpty() ? -1 : peaks.peek();
                ans -= (long)nums[prevMinI] * (i - prevMinI) * (prevMinI - prevprevMinI);
            }
            peaks.push(i);
        }

        peaks.clear();
        // max
        for (int i = 0; i <= n; i++) {
            while (!peaks.isEmpty() && nums[peaks.peek()] < (i == n ? Integer.MAX_VALUE : nums[i])) {
                int prevMaxI = peaks.pop();
                int prevprevMaxI = peaks.isEmpty() ? -1 : peaks.peek();
                ans += (long)nums[prevMaxI] * (i - prevMaxI) * (prevMaxI - prevprevMaxI);
            }
            peaks.push(i);
        }

        return ans;
    }
}
// @lc code=end
