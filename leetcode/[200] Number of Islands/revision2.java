/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (isNewIsland(visited, grid, row, col))
                    ans++;
            }
        }
        return ans;
    }

    private boolean isNewIsland(boolean[][] visited, char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == '0')
            return false;
        visited[row][col] = true;
        for (int[] dir : dirs) {
            isNewIsland(visited, grid, row + dir[0], col + dir[1]);
        }
        return true;
    }
}
// @lc code=end
