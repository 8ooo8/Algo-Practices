/*
 * @lc app=leetcode id=2101 lang=java
 *
 * [2101] Detonate the Maximum Bombs
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

/*
 * Tried 2 approaches.
 * One with a boolean array to record those visited bombs and this one resulted in ~285ms.
 * Another one, without the array, resulted in ~34ms.
 * */

class Solution {
    public int maximumDetonation(int[][] bombs) {
        int ans = 1, B = bombs.length;
        Set<Integer>[] memo = new HashSet[B];
        for (int i = 0; i < B; i++) {
            memo[i] = new HashSet<>();
            // dfs(bombs, new boolean[B], memo, i, i);
            dfs(bombs, memo, i, i);
            ans = Math.max(memo[i].size(), ans);
        }
        return ans;
    }

    // protected void dfs(int[][] bombs, boolean[] detonated, Set<Integer>[] memo, int i, int root) {
       // detonated[i] = true;
    protected void dfs(int[][] bombs, Set<Integer>[] memo, int i, int root) {
        if (memo[i] != null && !memo[i].isEmpty()) {
            memo[root].addAll(memo[i]);
            return;
        }

        memo[root].add(i);
        for (int j = 0; j < bombs.length; j++) {
            // if (detonated[j]) continue; [> The statement led to a much longer running time because it didn't count the detonated bombs from `memo[root].addAll(memo[i])`. <]
            if (memo[root].contains(j)) continue;
            int iX = bombs[i][0], iY = bombs[i][1], iR = bombs[i][2];
            int jX = bombs[j][0], jY = bombs[j][1];
            if ((long)Math.pow(iX - jX, 2) + Math.pow(iY - jY, 2) <= (long)iR * iR)
                // dfs(bombs, detonated, memo, j, root);
                dfs(bombs, memo, j, root);
        }
    }
}
// @lc code=end
