/*
 * @lc app=leetcode id=1041 lang=java
 *
 * [1041] Robot Bounded In Circle
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public boolean isRobotBounded(String instructions) {
        // algorithm: if it doesn't return to its original position after 4 cycles, it won't form a circle
        // explanation: 
        //   1. it doesn't matter how the path goes, just the xy-positions and the direction changes matter
        //   2. 3 possible direction changes - 90, 180, 270 degree to left/right
        //   3. after 4 cycles (or 2 cycles for 180 degree change), if it doesn't back to the initial position, it means it would start the same path at a different position and would keep this ahead and not going back.

        int x = 0, y = 0, dir = 0;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // compute for 1 cycle
        for (char i : instructions.toCharArray()) {
            if (i == 'G') {
                x += dirs[dir][0];
                y += dirs[dir][1];
            } else {
                dir = (dir + (i == 'L' ? 3 : 1)) % 4;
            }
        }

        // furthermore about the algorithm:
        // case of dir is 1 or 3: [cycle 1] x += X, y += Y > [cycle 2] x += Y, y += -X > [cycle 3] x += -X, y += -Y > [cycle 4] x += -Y, y += X, i.e. must back to the initial position afterwards
        // case of dir is 2: it must go back to the initial position after the 2nd cycle
        return (x == 0 && y == 0) || dir != 0;
    }
}
// @lc code=end
