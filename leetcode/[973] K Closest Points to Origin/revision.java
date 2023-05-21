/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] dist = new int[points.length][3];
        for (int i = 0; i < points.length; i++) {
            dist[i][0] = points[i][0];
            dist[i][1] = points[i][1];
            dist[i][2] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        }
        Arrays.sort(dist, (d1, d2) -> d1[2] - d2[2]);
        return Arrays.stream(dist).limit(k).map(d -> new int[]{d[0], d[1]}).toArray(int[][]::new);
    }
}
// @lc code=end
