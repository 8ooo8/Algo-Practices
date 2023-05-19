/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++)
                numOfIslands += scanIsland(grid, visited, x, y);
        }
        return numOfIslands;
    }

    // DFS
    private int scanIsland(char[][] grid, boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x >= grid[0].length || y >= grid.length || grid[y][x] == '0' || visited[y][x])
            return 0;

        visited[y][x] = true;
        scanIsland(grid, visited, x + 1, y);
        scanIsland(grid, visited, x - 1, y);
        scanIsland(grid, visited, x, y + 1);
        scanIsland(grid, visited, x, y - 1);
        return 1;
    }
}
// @lc code=end
