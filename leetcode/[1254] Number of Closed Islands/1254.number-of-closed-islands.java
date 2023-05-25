/*
 * @lc app=leetcode id=1254 lang=java
 *
 * [1254] Number of Closed Islands
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int closedIsland(int[][] grid) {
        int ret = 0;
        for (int y = 1; y < grid.length - 1; y++)
            for (int x = 1; x < grid[0].length - 1; x++)
                ret += dfs(y, x, grid) > 0 ? 1 : 0;
        return ret;
    }

    protected int dfs(int y, int x, int[][] grid) {
        if (y >= 0 && x >= 0 && y < grid.length && x < grid[0].length && grid[y][x] == 0) {
            grid[y][x] = 1; // marked as visited
            if (y == 0 || x == 0 || y == grid.length - 1 || x == grid[0].length - 1)
                return -10000; // note that 10000 is the max number of the grid cells
            return 1 + dfs(y + 1, x, grid) + dfs(y, x + 1, grid) + dfs(y - 1, x, grid) + dfs(y, x - 1, grid); // return +ve to mean it's a closed island
        }
        return 0; // return <= 0 to mean not a closed island
    }
}
// @lc code=end
