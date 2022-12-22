/*
 * @lc app=leetcode id=1027 lang=java
 *
 * [1027] Longest Arithmetic Subsequence
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int longestArithSeqLength(int[] nums) {
        HashMap<Integer,Integer>[] dp = (HashMap<Integer,Integer>[])new HashMap[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap();
            for (int j = i - 1; j >= 0; j--) {
                int diff = nums[i] - nums[j];
                int diffCount = dp[j].getOrDefault(diff, 0) + 1;
                dp[i].compute(diff, (k, v) -> v != null && v >= diffCount ? v : diffCount);
            }
        }
        return Arrays.stream(dp).flatMap(e -> e.values().stream()).mapToInt(Integer::intValue).max().getAsInt() + 1; // may shorten the code by keeping calculating the ans during the above loop
    }
}
// @lc code=end
