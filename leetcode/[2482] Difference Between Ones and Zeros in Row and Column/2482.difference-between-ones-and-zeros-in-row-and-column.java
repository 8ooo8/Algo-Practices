/*
 * @lc app=leetcode id=2482 lang=java
 *
 * [2482] Difference Between Ones and Zeros in Row and Column
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        final int ROW = grid.length, COL = grid[0].length;
        int[] onesMinusZerosRows = new int[ROW]; // precompute onesRow - zerosRow
        
        for (int r = 0; r < ROW; r++)
            for (int c = 0; c < COL; c++) {
                if (grid[r][c] == 0) grid[r][c] = -1; // 0 -> -1 to make the calculation easier
                onesMinusZerosRows[r] += grid[r][c];
            }

        for (int c = 0; c < COL; c++) {
            int onesMinusZerosCol = 0;
            for (int r = 0; r < ROW; r++) onesMinusZerosCol += grid[r][c];
            for (int r = 0; r < ROW; r++) grid[r][c] = onesMinusZerosCol + onesMinusZerosRows[r];
        }
        return grid;
    }
}
// @lc code=end
