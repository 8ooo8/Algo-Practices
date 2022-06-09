// @algorithm @lc id=268 lang=java
// @title missing-number
/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        boolean[] has = new boolean[nums.length + 1];
        IntStream.of(nums).forEach(n -> has[n] = true);
        int i;
        for (i = 0; i < has.length; i++)
            if (!has[i]) break;
        return i;
    }
}
// @lc code=end
