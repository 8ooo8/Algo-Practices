/*
 * @lc app=leetcode id=1151 lang=java
 *
 * [1151] Minimum Swaps to Group All 1's Together
 */

// @lc code=start
class Solution {
    public int minSwaps(int[] data) {
        int ttlNumOf1s = (int)Arrays.stream(data).sum();
        int ans = Integer.MAX_VALUE;
        int swaps = 0;
        for (int r = 0; r < data.length; r++) {
            swaps += data[r] == 0 ? 1 : 0;
            if (r >= ttlNumOf1s)
                swaps -= data[r - ttlNumOf1s] == 0 ? 1 : 0;
            if (r >= ttlNumOf1s - 1)
                ans = Math.min(ans, swaps);
        }
        return ans;
    }
}
// @lc code=end
