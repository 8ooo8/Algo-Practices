/*
 * @lc app=leetcode id=1547 lang=java
 *
 * [1547] Minimum Cost to Cut a Stick
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    int[][] costs; // memo
    int[] sortedCuts;

    public int minCost(int n, int[] cuts) {
        final int m = cuts.length;
        costs = new int[m + 2][m + 2];
        sortedCuts = new int[m + 2];

        System.arraycopy(cuts, 0, sortedCuts, 1, m);
        sortedCuts[sortedCuts.length - 1] = n;
        Arrays.sort(sortedCuts);
        return cost(0, m + 1);
    }

    protected int cost(int left, int right) {
        if (costs[left][right] > 0 || right - left <= 1)
            return costs[left][right];

        int ans = cost(left + 1, right) + sortedCuts[right] - sortedCuts[left];
        for (int mid = left + 2; mid < right; mid++)
            ans = Math.min(ans, cost(left, mid) + cost(mid, right) + sortedCuts[right] - sortedCuts[left]);
        return costs[left][right] = ans;
    }
}
// @lc code=end
