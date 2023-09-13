/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>(); // <sum, count>
        return combs(nums, target, memo);
    }

    private int combs(int[] nums, int remain, Map<Integer, Integer> memo) {
        if (remain <= 0) return remain == 0 ? 1 : 0;
        if (memo.containsKey(remain)) return memo.get(remain);

        int res = 0;
        for (int n : nums) res += combs(nums, remain - n, memo);
        memo.put(remain, res);
        return res;
    }
}
// @lc code=end
