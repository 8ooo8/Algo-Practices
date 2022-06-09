/*
 * @lc app=leetcode id=853 lang=java
 *
 * [853] Car Fleet
 */

// @lc code=start
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Integer>[] cars = new List[position.length];
        for (int i = 0; i < position.length; i++)
            cars[i] = Arrays.asList(position[i], speed[i]);
        Arrays.sort(cars, (c1, c2) -> c2.get(0) - c1.get(0));

        double lastFleetArrivalTime = -1;
        int ans = 0;
        for (List<Integer> c : cars) {
            double thisCarArrivalTime = (target - c.get(0)) / (double)c.get(1);
            if (thisCarArrivalTime > lastFleetArrivalTime) {
                ans++;
                lastFleetArrivalTime = thisCarArrivalTime;
            }
        }
        return ans;
    }
}
// @lc code=end
