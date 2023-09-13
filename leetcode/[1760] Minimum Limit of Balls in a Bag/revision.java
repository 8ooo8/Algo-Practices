/*
 * @lc app=leetcode id=1760 lang=java
 *
 * [1760] Minimum Limit of Balls in a Bag
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = Arrays.stream(nums).max().getAsInt();
        while (r > l) {
            int m = (l + r) / 2;
            int operations = 0;
            for (int n : nums)
                operations += (n - 1) / m;
            if (operations > maxOperations)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }
}
// @lc code=end
