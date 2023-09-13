/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        res.add(Arrays.asList(1));
        for (int r = 1; r < numRows; r++) {
            List<Integer> newRow = new ArrayList<>(r + 1), lastRow = res.get(res.size() - 1);
            for (int c = 0; c <= r; c++)
                newRow.add((c > 0 ? lastRow.get(c - 1) : 0) + (c < lastRow.size() ? lastRow.get(c) : 0));
            res.add(newRow);
        }
        return res;
    }
}
// @lc code=end
