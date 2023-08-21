/*
 * @lc app=leetcode id=1427 lang=java
 *
 * [1427] Perform String Shifts
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public String stringShift(String s, int[][] shift) {
        int S = s.length(), left = 0; // `left` is the index of the leftmost character of `s`
        for (int[] sh : shift) left += (sh[0] == 0 ? -1 : 1) * sh[1]; // compute the net shift
        while (left < 0) left += S; // when `left` gets a net left shift
        left %= S; // when `left` gets a net right shift with magnitute > `S`
        return left == 0 ? s : s.substring(S - left) + s.substring(0, S - left);
    }
}
// @lc code=end
