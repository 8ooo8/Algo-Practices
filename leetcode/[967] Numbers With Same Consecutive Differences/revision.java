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
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++)
            dfs(n, k, res, i, 1);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(int n, int k, List<Integer> res, int num, int length) {
        System.out.println(num);
        if (length == n) {
            res.add(num);
            return;
        }

        if ((num % 10) - k >= 0)
            dfs(n, k, res, num * 10 + (num % 10) - k, length + 1);
        if ((num % 10) + k <= 9 && k != 0)
            dfs(n, k, res, num * 10 + (num % 10) + k, length + 1);
    }
}
// @lc code=end
