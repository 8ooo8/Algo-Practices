/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (r >= l) {
            if (numbers[l] + numbers[r] == target)
                break;
            if (numbers[l] + numbers[r] <= target)
                l++;
            else if (numbers[l] + numbers[r] >= target)
                r--;
        }
        return new int[]{l + 1, r + 1};
    }
}
// @lc code=end
