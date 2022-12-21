/*
 * @lc app=leetcode id=967 lang=java
 *
 * [967] Numbers With Same Consecutive Differences
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= 9; i++)
            dfs(n - 1, k, i, ans);

        return ans.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(int remainDigits, int k, int num, List<Integer> ans) {
        if (remainDigits <= 0) {
            ans.add(num);
            return;
        }
        
        int lastDigit = num % 10;
        if (lastDigit + k <= 9)
            dfs(remainDigits - 1, k, num * 10 + k + lastDigit, ans);
        if (lastDigit - k >= 0 && k != 0)
            dfs(remainDigits - 1, k, num * 10 - k + lastDigit, ans);
    }
}
// @lc code=end
