/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */

// @lc code=start
class NumMatrix {
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        sum = new int[matrix.length][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[0].length; c++)
                sum[r][c + 1] = matrix[r][c] + sum[r][c];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for (int r = row1; r <= row2; r++)
            ans += sum[r][col2 + 1] - sum[r][col1];
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end
