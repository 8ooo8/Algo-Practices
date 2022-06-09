/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1, sum;
        while (hi > lo) {
            if ((sum = numbers[hi] + numbers[lo]) == target)
                break;
            else if (sum < target)
                lo++;
            else
                hi--;
        }
        return new int[] {lo + 1, hi + 1}; // said to be having one solution
    }
}
// @lc code=end
