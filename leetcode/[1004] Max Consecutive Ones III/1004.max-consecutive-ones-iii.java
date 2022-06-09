/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        Deque<Integer> flipped = new LinkedList<>();
        int ans = 0;
        for (int from = 0, to = 0; to < nums.length; to++) {
            if (nums[to] == 0) {
                if (k == 0) {
                    from = to + 1;
                } else if (flipped.size() < k) {
                    nums[to] = 1;
                    flipped.offerLast(to);
                } else {
                    int backToZero = flipped.pollFirst();
                    nums[backToZero] = 0;
                    from = backToZero + 1;
                    flipped.offerLast(to);
                    nums[to] = 1;
                }
            }
            
            ans = from <= to ? Math.max(to - from + 1, ans) : ans;
        }
        return ans;
    }
}
// @lc code=end
