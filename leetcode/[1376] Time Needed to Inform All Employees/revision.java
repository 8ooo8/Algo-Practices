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
    private int ttlMinutes(int i, int[] manager, int[] informTime, boolean[] visited) {
        if (manager[i] == -1 || visited[i])
            return informTime[i];
        visited[i] = true;
        return informTime[i] += ttlMinutes(manager[i], manager, informTime, visited);
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        boolean[] visited = new boolean[informTime.length];
        for (int i = 0; i < manager.length; i++)
            ttlMinutes(i, manager, informTime, visited);
        return Arrays.stream(informTime).max().getAsInt();
    }
}
// @lc code=end
