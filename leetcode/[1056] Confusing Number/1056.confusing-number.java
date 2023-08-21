/*
 * @lc app=leetcode id=1056 lang=java
 *
 * [1056] Confusing Number
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public boolean confusingNumber(int n) {
        int[] rotations = new int[]{0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        int m = n, rotated = 0;
        while (m > 0) {
            if (rotations[m % 10] < 0) return false;
            rotated = rotated * 10 + rotations[m % 10];
            m /= 10;
        }
        return rotated != n;
    }
}
// @lc code=end
