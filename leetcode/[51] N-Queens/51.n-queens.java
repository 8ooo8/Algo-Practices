/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] graph = new char[n][n];
        for (char[] row : graph) Arrays.fill(row, '.');
        dfs(n, ans, 0, graph);
        return ans;
    }

    private void dfs(int n, List<List<String>> ans, int row, char[][] graph) {
        if (row == n) {
            List<String> oneSolution = new ArrayList<>();
            for (char[] str : graph) oneSolution.add(String.valueOf(str));
            ans.add(oneSolution);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (isValid(n, graph, row, c)) {
                graph[row][c] = 'Q';
                dfs(n, ans, row + 1, graph);
                graph[row][c] = '.';
            }
        }
    }

    private boolean isValid(int n, char[][] graph, int row, int col) {
        for (int r = 0; r < row; r++)
            if (graph[r][col] == 'Q') return false;
        for (int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++)
            if (graph[r][c] == 'Q') return false;
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--)
            if (graph[r][c] == 'Q') return false;
        return true;
    }
}
// @lc code=end
