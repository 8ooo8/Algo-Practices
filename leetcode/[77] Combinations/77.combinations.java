/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    private void combine(int n, List<Integer> combined, List<List<Integer>> res, int i, int toCombine) {
        if (toCombine == 0) {
            res.add(new ArrayList(combined));
            return;
        }

        for (int j = i; j <= n - toCombine + 1; j++) {
            combined.add(j);
            combine(n, combined, res, j + 1, toCombine - 1);
            combined.remove(combined.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(n, new ArrayList<>(), res, 1, k);
        return res;
    }
}
// @lc code=end
