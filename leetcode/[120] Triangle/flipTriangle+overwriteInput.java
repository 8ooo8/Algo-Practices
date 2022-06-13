/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int row = triangle.size() - 2; row >= 0; row--) {
            List<Integer> prevRowCells = triangle.get(row + 1);
            List<Integer> cells = triangle.get(row);
            for (int col = 0; col < cells.size(); col++)
                cells.set(col, cells.get(col) + Math.min(prevRowCells.get(col), prevRowCells.get(col + 1)));
        }
        return triangle.get(0).get(0);
    }
}
// @lc code=end
