/*
 * @lc app=leetcode id=1151 lang=java
 *
 * [1151] Minimum Swaps to Group All 1's Together
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int minSwaps(int[] data) {
        int numOf1s = Arrays.stream(data).sum(); // improved approach: no need to firstly scan the array to get numOf1s, instead, (1) count the max amount of 1s in the windows + (2) count 1s during the window sliding
        int swaps = numOf1s, ret = Integer.MAX_VALUE; // swaps = numOf1s as the beginning in which the sliding window has a size of 0
        for (int l = 0, r = 0; r < data.length; r++) { // may replace the 2 pointers with a double-ended queue, i.e. Deque in Java
            swaps -= data[r];
            if (r - l >= numOf1s)
                swaps += data[l++];
            ret = Math.min(ret, swaps);
        }
        return ret;
    }
}
// @lc code=end
