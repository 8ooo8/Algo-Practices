/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int x = 0; x < grid.length; x++)
            for (int y = 0; y < grid[0].length; y++) {
                if (!visited[x][y] && grid[x][y] == '1')
                    ans++;
                DFS(visited, grid, x, y);
            }
        return ans;
    }

    private void DFS(boolean[][] visited, char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y] || grid[x][y] == '0')
            return;
        visited[x][y] = true;
        DFS(visited, grid, x + 1, y);
        DFS(visited, grid, x - 1, y);
        DFS(visited, grid, x, y + 1);
        DFS(visited, grid, x, y - 1);
    }
}
// @lc code=end
