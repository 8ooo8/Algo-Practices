/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    int ans = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] diagonal45 = new boolean[2 * n - 1]; // 45 angle
        boolean[] diagonal135 = new boolean[2 * n - 1]; // 135 angle
        dfs(n, 0, cols, diagonal45, diagonal135);
        return ans;
    }

    private void dfs(int n, int row, boolean[] cols, boolean[] diagonal45, boolean[] diagonal135) {
        if (row == n) {
            ans++;
            return;
        }

        for (int c = 0; c < n; c++) {
            int d45Idx = row + c;
            int d135Idx = row - c + n - 1;
            if (cols[c] || diagonal45[d45Idx] || diagonal135[d135Idx]) continue;
            cols[c] = diagonal45[d45Idx] = diagonal135[d135Idx] = true;
            dfs(n, row + 1, cols, diagonal45, diagonal135);
            cols[c] = diagonal45[d45Idx] = diagonal135[d135Idx] = false;
        }
    }
}
// @lc code=end
