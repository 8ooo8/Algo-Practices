/*
 * @lc app=leetcode id=885 lang=java
 *
 * [885] Spiral Matrix III
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    int i;

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] ans = new int[rows * cols][2];
        ans[0][0] = rStart;
        ans[0][1] = cStart;

        int spiralCycle = 1;
        for (i = 1; i < ans.length; spiralCycle++) {
            int rightCol = cStart + spiralCycle;
            int leftCol = cStart - spiralCycle;
            int bottomRow = rStart + spiralCycle;
            int topRow = rStart - spiralCycle;

            int row = rStart;
            int col = rightCol;
            for (; row < bottomRow; ++row) visit(rows, cols, row, col, ans);
            for (; col > leftCol; --col) visit(rows, cols, row, col, ans);
            for (; row > topRow; --row) visit(rows, cols, row, col, ans);
            for (; col < rightCol + 1; ++col) visit(rows, cols, row, col, ans);
            for (; row < rStart; ++row) visit(rows, cols, row, col, ans);
        }
        return ans;
    }

    private void visit(int rows, int cols, int targetRow, int targetCol, int[][] ans) {
        if (targetRow >= 0 && targetRow < rows && targetCol >= 0 && targetCol < cols) {
            ans[i][0] = targetRow;
            ans[i++][1] = targetCol;
        }
    }
}
// @lc code=end
