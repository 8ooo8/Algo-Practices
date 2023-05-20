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
            for (int i = u[0]; i <= u[1]; i++)
                retArray[i] += u[2];
        }
        return retArray;
    }
}
// @lc code=end
