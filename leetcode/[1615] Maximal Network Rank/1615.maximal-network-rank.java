/*
 * @lc app=leetcode id=1615 lang=java
 *
 * [1615] Maximal Network Rank
 */

// @lc code=start
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set> graph = new HashMap<>(); // use Map & Set instead of array to gain advantage from .size()
        for (int[] r : roads) {
            graph.computeIfAbsent(r[0], HashSet<Integer>::new).add(r[1]);
            graph.computeIfAbsent(r[1], HashSet<Integer>::new).add(r[0]);
        }

        int ans = 0;
        // solve by brute force
        for (int i = 0; i < n; i++) {
            if (!graph.containsKey(i)) // may create empty elements for the map object to avoid the null checking
                continue;

            Set cityI = graph.get(i);
            for (int j = i + 1; j < n; j++) {
                if (!graph.containsKey(j))
                    continue;
                ans = Math.max(ans, cityI.size() + graph.get(j).size() - (cityI.contains(j) ? 1 : 0));
            }
        }
        return ans;
    }
}
// @lc code=end
