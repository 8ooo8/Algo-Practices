/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<Integer> ret = new ArrayList<>();
        int y = 0, x = -1, Y = matrix.length, X = matrix[0].length, dir = 0, dirChange = 0;
        do {
            int newY = y + dirs[dir % 4][0];
            int newX = x + dirs[dir % 4][1];
            if (newY < 0 || newX < 0 || newY >= Y || newX >= X || matrix[newY][newX] < -100) {
                dir = (dir + ++dirChange) % 4;
            } else {
                y = newY;
                x = newX;
                ret.add(matrix[y][x]);
                matrix[y][x] = -101; // marked as visited
                dirChange = 0;
            }
        } while (dirChange < 2);
        return ret;
    }
}
// @lc code=end
