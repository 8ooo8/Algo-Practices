/*
 * @lc app=leetcode id=1730 lang=java
 *
 * [1730] Shortest Path to Get Food
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int getFood(char[][] grid) {
        Queue<Integer> myLocations = new ArrayDeque<>();
        final int COL = grid[0].length;
        for (int y = 0; y < grid.length; y++)
            for (int x = 0; x < COL; x++)
                if (grid[y][x] == '*') {
                    myLocations.offer(y * COL + x);
                    break;
                }

        int ret = 0;
        while (!myLocations.isEmpty()) {
            final int LOCATIONS_NUM = myLocations.size();
            for (int i = 0; i < LOCATIONS_NUM; i++) {
                int location = myLocations.poll();
                int y = location / COL;
                int x = location % COL;

                if (grid[y][x] == '#')
                    return ret;
                if (grid[y][x] == 'X')
                    continue;

                grid[y][x] = 'X'; // marked as visited
                if (y - 1 >= 0)
                    myLocations.offer(location - COL);
                if (y + 1 < grid.length)
                    myLocations.offer(location + COL);
                if (x - 1 >= 0)
                    myLocations.offer(location - 1);
                if (x + 1 < COL)
                    myLocations.offer(location + 1);
            }
            ret++;
        }

        return -1;
    }
}
// @lc code=end
