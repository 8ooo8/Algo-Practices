/*
 * @lc app=leetcode id=1884 lang=java
 *
 * [1884] Egg Drop With 2 Eggs and N Floors
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int twoEggDrop(int n) {
        int moves = 1, maxFloors = 0;
        while ((maxFloors += moves) < n) ++moves;
        return moves;
    }
}
        
/* Better approach 1:
 * Binary search + "moves * (moves + 1) / 2 >= n"
 *
 * Better approach 2:
 * Solve the equation "moves * (moves + 1) / 2 >= n" to achieve O(1) time complexity
 */

// @lc code=end
