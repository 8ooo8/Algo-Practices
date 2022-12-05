/*
 * @lc app=leetcode id=926 lang=java
 *
 * [926] Flip String to Monotone Increasing
 */

// @lc code=start
class Solution {
    public int minFlipsMonoIncr(String s) {
        int N = s.length();
        int[] zeroCount = new int[N + 1];
        for (int i = 0; i < N; i++) {
            zeroCount[i + 1] = zeroCount[i] + (s.charAt(i) == '0' ? 1 : 0);
        }

            // System.out.println(Arrays.toString(zeroCount));
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N + 1; i++) {
            ans = Math.min(ans, (i - zeroCount[i]) + (zeroCount[N] - zeroCount[i]));
            // System.out.println(Arrays.toString(new int[]{i, ans, (i - zeroCount[i]) , ( zeroCount[N] - zeroCount[i])}));
        }
        return ans;
    }
}
// @lc code=end
