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
        int R = grid.length, C = grid[0].length;
        Queue<Integer> islandLocation = new ArrayDeque<>();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == '0')
                    continue;
                islandLocation.offer(r * C + c);
                ++numOfIslands;

                while (!islandLocation.isEmpty()) {
                    int islandR = islandLocation.peek() / C;
                    int islandC = islandLocation.remove() % C;
                    
                    if (islandR < 0 || islandC < 0 || islandR >= R || islandC >= C || grid[islandR][islandC] == '0')
                        continue;

                    grid[islandR][islandC] = '0'; // mark as visited
                    islandLocation.offer((islandR + 1) * C + islandC);
                    islandLocation.offer((islandR - 1) * C + islandC);
                    if (islandC < C - 1)
                        islandLocation.offer(islandR * C + islandC + 1);
                    if (islandC > 0)
                        islandLocation.offer(islandR * C + islandC - 1);
                }
            }
        }

        return numOfIslands;
    }
}
// @lc code=end
