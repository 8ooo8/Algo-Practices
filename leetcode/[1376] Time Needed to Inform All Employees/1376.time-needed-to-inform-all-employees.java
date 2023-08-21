/*
 * @lc app=leetcode id=1376 lang=java
 *
 * [1376] Time Needed to Inform All Employees
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] subordinates = new ArrayList[n];
        for (int i = 0; i < n; i++)
            subordinates[i] = new ArrayList<>();

        for (int i = 0; i < n; i++)
            if (i != headID) subordinates[manager[i]].add(i);

        return getMaxTime(headID, informTime, subordinates, 0);
    }

    protected int getMaxTime(int i, int[] informTime, List<Integer>[] subordinates, int ttlTime) {
        int maxTime = (ttlTime += informTime[i]);
        for (Integer sub : subordinates[i])
            maxTime = Math.max(maxTime, getMaxTime(sub, informTime, subordinates, ttlTime));
        return maxTime;
    }
}
// @lc code=end
