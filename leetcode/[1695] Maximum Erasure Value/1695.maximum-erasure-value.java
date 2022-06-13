/*
 * @lc app=leetcode id=1695 lang=java
 *
 * [1695] Maximum Erasure Value
 */

// @lc code=start
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> occurred = new HashMap<>();
        int[] sums = new int[nums.length];
        int ans = 0;
        for (int left = -1, right = 0; right < nums.length; right++) {
            int rightValue = nums[right];
            Integer newLeft = occurred.put(rightValue, right);
            if (newLeft != null && newLeft > left)
                left = newLeft;
            sums[right] = rightValue + (right > 0 ? sums[right - 1] : 0);
            ans = Math.max(sums[right] - (left >= 0 ? sums[left] : 0), ans);
            // System.out.println(left + " - " + right + ", ans = " + ans);
        }
        return ans;
    }
}
// @lc code=end
