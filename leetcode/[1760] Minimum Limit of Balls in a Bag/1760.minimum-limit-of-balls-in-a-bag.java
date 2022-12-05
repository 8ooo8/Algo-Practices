/*
 * @lc app=leetcode id=1760 lang=java
 *
 * [1760] Minimum Limit of Balls in a Bag
 */

// @lc code=start
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        while (right > left) {
            int mid = (left + right) / 2;
            int operations = 0;
            for (int n : nums)
                operations += (n - 1) / mid;
            if (operations > maxOperations)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
// @lc code=end
