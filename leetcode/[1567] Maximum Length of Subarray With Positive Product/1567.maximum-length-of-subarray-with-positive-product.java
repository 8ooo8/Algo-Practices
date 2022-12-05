/*
 * @lc app=leetcode id=1567 lang=java
 *
 * [1567] Maximum Length of Subarray With Positive Product
 */

// @lc code=start
class Solution {
    public int getMaxLen(int[] nums) {
        int firstNegative = -1, negativeCount = 0, lastZero = -1, len = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                firstNegative = -1;
                negativeCount = 0;
                lastZero = i;
            }
            if (nums[i] < 0) {
                if (firstNegative < 0)
                    firstNegative = i;
                negativeCount++;
            }
            len = negativeCount % 2 == 0 ? i - lastZero : i - firstNegative;
            ans = Math.max(len, ans);
        }
        return ans;
    }
}
// @lc code=end
