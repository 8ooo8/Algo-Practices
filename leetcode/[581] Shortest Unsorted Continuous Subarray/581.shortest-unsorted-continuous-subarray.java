/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int r = -1, l = -1, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i + 1 < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i + 1] < max)
                r = i + 1;
        }
        for (int i = nums.length - 1; i - 1 >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i - 1] > min)
                l = i - 1;
        }
        System.out.println(l + ", " + r);
        if (r < 0 && l < 0)
            return 0;
        r = r < 0 ? nums.length - 1 : r;
        l = l < 0 ? 0 : l;
        return r - l + 1;
    }
}
// @lc code=end
