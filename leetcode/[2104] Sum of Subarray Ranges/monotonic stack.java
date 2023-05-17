/*
 * @lc app=leetcode id=2104 lang=java
 *
 * [2104] Sum of Subarray Ranges
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public long subArrayRanges(int[] nums) {
        long ret = 0;       
        int N = nums.length;
        Stack<Integer> s = new Stack<>();

        // find the sum of the mins
        for (int r = 0; r <= N; ++r) {
            while (!s.isEmpty() && (r == N || nums[r] <= nums[s.peek()])) {
                int m = s.pop();
                int l = s.isEmpty() ? -1 : s.peek();
                ret -= (long)nums[m] * (m - l) * (r - m);
            }
            s.add(r);
        }

        // find the sum of the max
        s.clear();
        for (int r = 0; r <= N; ++r) {
            while (!s.isEmpty() && (r == N || nums[r] >= nums[s.peek()])) {
                int m = s.pop();
                int l = s.isEmpty() ? -1 : s.peek();
                ret += (long)nums[m] * (m - l) * (r - m);
            }
            s.add(r);
        }

        return ret;
    }
}
// @lc code=end
