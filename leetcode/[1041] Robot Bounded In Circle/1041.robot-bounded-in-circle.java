/*
 * @lc app=leetcode id=1041 lang=java
 *
 * [1041] Robot Bounded In Circle
 */

// @lc code=start
class Solution {
    public boolean isRobotBounded(String instructions) {
        int x, y;
        x = y = 0;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int dir = 0;
        for (char c : instructions.toCharArray()) {
            switch(c) {
                case 'G':
                    y += dirs[dir][0];
                    x += dirs[dir][1];
                    break;
                case 'L':
                    dir = (dir + 1) % 4;
                    break;
                case 'R':
                    dir = (dir - 1 + 4) % 4;
                    break;
            }
        }
        return (x == 0 && y == 0) || dir != 0;
    }
}
// @lc code=end
