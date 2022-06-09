/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private boolean binarySearch(int[][] matrix, int target, int fromRow, int fromCol, int toRow, int toCol) {
        int from = fromCol + fromRow * matrix[0].length;
        int to = toCol + toRow * matrix[0].length;
        // System.out.println("from: " +from + ", to: " + to);

        if (to - from <= 1)
            return matrix[fromRow][fromCol] == target || matrix[toRow][toCol] == target;
        int mid = (to - from) / 2 + from;
        int midRow = mid / matrix[0].length, midCol = mid - midRow * matrix[0].length;
        // System.out.println("midRow: " +midRow + ", midCol: " + midCol);
        if (matrix[midRow][midCol] > target)
            return binarySearch(matrix, target, fromRow, fromCol, midRow, midCol);
        return binarySearch(matrix, target, midRow, midCol, toRow, toCol);
    }
}
// @lc code=end
