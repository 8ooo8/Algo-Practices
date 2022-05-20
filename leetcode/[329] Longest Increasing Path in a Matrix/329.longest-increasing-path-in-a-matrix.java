/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 */

// @lc code=start
class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int[][] maxPaths = new int[matrix.length][matrix[0].length];
        int ans = 1;
        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[0].length; col++)
                ans = Math.max(ans, dfs(matrix, row, col, maxPaths));
        return ans;
    }

    private int dfs(int[][] matrix, int row, int col, int[][] maxPaths) {
        if (maxPaths[row][col] != 0)
            return maxPaths[row][col];

        int maxPath = 1;
        for (int[] dir : dirs) {
            int nextRow = row + dir[0], nextCol = col + dir[1];
            if (nextRow >= 0 && nextCol >= 0
                && nextRow < matrix.length && nextCol < matrix[0].length
                && matrix[nextRow][nextCol] > matrix[row][col])
            {
                maxPath = Math.max(1 + dfs(matrix, nextRow, nextCol, maxPaths), maxPath);
            }
        }
        return (maxPaths[row][col] = maxPath);
    }
}
// @lc code=end
