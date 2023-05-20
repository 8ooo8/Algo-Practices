/*
 * @lc app=leetcode id=370 lang=java
 *
 * [370] Range Addition
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] retArray = new int[length];

        for (int[] u : updates) {
            retArray[u[0]] += u[2];
            if (u[1] < length - 1)
                retArray[u[1] + 1] -= u[2];
        }

        for (int i = 1; i < length; i++) {
            retArray[i] = retArray[i] + retArray[i - 1];
        }

        return retArray;
    }
}
// @lc code=end
