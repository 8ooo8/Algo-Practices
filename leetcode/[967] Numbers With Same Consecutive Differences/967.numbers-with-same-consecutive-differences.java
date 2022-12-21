/*
 * @lc app=leetcode id=967 lang=java
 *
 * [967] Numbers With Same Consecutive Differences
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Queue<Integer> ans = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        int leastValue = (int)Math.pow(10, n - 1);

        while (ans.peek() < leastValue) {
            int num = ans.poll();
            int lastDigit = num % 10;
            if (lastDigit + k <= 9)
                ans.offer(num * 10 + k + lastDigit);
            if (lastDigit - k >= 0 && k != 0)
                ans.offer(num * 10 - k + lastDigit);
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}
// @lc code=end
