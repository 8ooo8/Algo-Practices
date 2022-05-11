/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++)
                if (board[r][c] != '.') {
                    int digit = board[r][c] - '1';
                    if (rows[r][digit] || cols[c][digit] || boxes[r/3*3 + c/3][digit])
                        return false;
                    rows[r][digit] = true;
                    cols[c][digit] = true;
                    boxes[r/3*3 + c/3][digit] = true;
                }

        return true;
    }
}
// @lc code=end
