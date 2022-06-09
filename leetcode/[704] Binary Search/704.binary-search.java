/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int from, int to) {
        if (to - from <= 1) {
            if (nums[from] == target) return from;
            if (nums[to] == target) return to;
            return -1;
        }
        
        int mid = (to - from) / 2 + from;
        if (nums[mid] > target)
            return binarySearch(nums, target, from, mid);
        return binarySearch(nums, target, mid, to);
    }
}
// @lc code=end
