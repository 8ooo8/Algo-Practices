/*
 * @lc app=leetcode id=565 lang=java
 *
 * [565] Array Nesting
 */

// @lc code=start
class Solution {
    int helpFunc(int[] nums, boolean[] visited, int[] setLengths, int i) {
        if (visited[i]) return setLengths[i];
        visited[i] = true;
        return (setLengths[i] = helpFunc(nums, visited, setLengths, nums[i]) + 1);
    }
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int[] setLengths = new int[nums.length];
        int maxNest = 0;
        for (int i = 0; i < nums.length; i++) {
            maxNest = Math.max(helpFunc(nums, visited, setLengths, i), maxNest);
        }
        return maxNest;
    }
}
// @lc code=end
