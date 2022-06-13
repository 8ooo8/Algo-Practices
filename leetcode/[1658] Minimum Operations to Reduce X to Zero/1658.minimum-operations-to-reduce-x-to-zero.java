/*
 * @lc app=leetcode id=1658 lang=java
 *
 * [1658] Minimum Operations to Reduce X to Zero
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums, int x) {
        int ans = Integer.MAX_VALUE;

        Map<Integer, Integer> leftSums = new HashMap<>(nums.length + 1);
        for (int left = -1, sum = 0; left < nums.length; left++)
            leftSums.put((sum += left >= 0 ? nums[left] : 0), left);

        for (int right = nums.length, rightSum = 0; right >= 0; right--) {
            rightSum += right < nums.length ? nums[right] : 0;
            int leftSum = x - rightSum;
            if (leftSums.containsKey(leftSum) && leftSums.get(leftSum) < right)
                ans = Math.min(leftSums.get(leftSum) + 1 + nums.length - right, ans);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
// @lc code=end
