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
        int res = 0;
        for (int r = 1; r < grid.length - 1; r++)
            for (int c = 1; c < grid[0].length - 1; c++)
                if (grid[r][c] == 0) 
                    res += isClosed(grid, r, c) > 0 ? 1 : 0;
        return res;
    }

    private int isClosed(int[][] grid, int r, int c) {
        if (r == 0 || c == 0 || r == grid.length - 1 || c == grid[0].length - 1)
            return grid[r][c] == 1 ? 1 : -10000; // note that 10000 is the max number of the grid cells
        if (grid[r][c] == 0) {
            grid[r][c] = 1; // marked as visited
            return isClosed(grid, r - 1, c) + isClosed(grid, r + 1, c) + isClosed(grid, r, c -1) + isClosed(grid, r, c + 1);
        }
        return 1;
    }
}
// @lc code=end
