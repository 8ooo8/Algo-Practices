/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */

// @lc code=start
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<List<Integer>>> travelTimes = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++)
            travelTimes.add(new LinkedList<>());
        for (int i = 0; i < times.length; i++)
            travelTimes.get(times[i][0]).add(Arrays.asList(times[i][1], times[i][2])); // effective when n is very large & it's a sparse graph, though here n is said to not larger than 100

        int[] minTimes = new int[n + 1];
        boolean[] foundMinTimes = new boolean[n + 1];
        Arrays.fill(minTimes, Integer.MAX_VALUE);
        minTimes[k] = 0;
        for (int count = 0; count < n; count++) {
            int minValue = Integer.MAX_VALUE, minIdx = -1;
            for (int u = 1; u <= n; u++) {
                if (!foundMinTimes[u] && minValue > minTimes[u]) {
                    minValue = minTimes[u];
                    minIdx = u;
                }
            }
            if (minIdx < 0) 
                return -1; // when impossible for all nodes to receive the signal
            foundMinTimes[minIdx] = true;
            List<List<Integer>> travelTimesToProcess = travelTimes.get(minIdx);
            for (List<Integer> time : travelTimesToProcess) {
                System.out.println(time);
                minTimes[time.get(0)] = Math.min(minTimes[time.get(0)], minTimes[minIdx] + time.get(1));
            }
        }
        
        int maxTime = 0;
        for (int i = 1; i < minTimes.length; i++)
            maxTime = Math.max(maxTime, minTimes[i]);
        return maxTime;
    }
}
// @lc code=end
