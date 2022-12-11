/*
 * @lc app=leetcode id=1304 lang=java
 *
 * [1304] Find N Unique Integers Sum up to Zero
 */

// @lc code=start
class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        for (int i = 0; i < n / 2; i++) {
            ans[2 * i] = i + 1;
            ans[2 * i + 1] = - i - 1;
        }
        if (n % 2 == 1)
            ans[n - 1] = 0;
        return ans;
    }
}
// @lc code=end
