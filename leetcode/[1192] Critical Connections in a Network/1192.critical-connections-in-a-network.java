/*
 * @lc app=leetcode id=1192 lang=java
 *
 * [1192] Critical Connections in a Network
 */

// @lc code=start
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();

        int[] timestamps = new int[n];
        List[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (List<Integer> c : connections) {
            graph[c.get(0)].add(c.get(1));
            graph[c.get(1)].add(c.get(0));
        }

        dfs(graph, timestamps, 1, 0, -1, ans, n);
        return ans;
    } 

    private int dfs(List[] graph, int[] timestamps, int currentTime, int currentNode, int parentNode, List<List<Integer>> ans, int n) {
        if (timestamps[currentNode] > 0)
           return timestamps[currentNode];
        
        timestamps[currentNode] = currentTime;
        int minTimestamp = currentTime;
        for (int toNode : (List<Integer>)graph[currentNode]) {
            if (toNode != parentNode)
                minTimestamp = Math.min(minTimestamp, dfs(graph, timestamps, currentTime + 1, toNode, currentNode, ans, n));
        }

        if (minTimestamp >= currentTime && parentNode >= 0)
            ans.add(Arrays.asList(parentNode, currentNode));

        return minTimestamp;
    }
}
// @lc code=end
