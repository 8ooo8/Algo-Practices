/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
import java.util.Optional;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int n : nums)
            m.compute(n, (num, occurrence) -> Optional.ofNullable(occurrence).orElse(0) + 1);
        List<Map.Entry<Integer, Integer>> l = new ArrayList<>(m.entrySet());
        l.sort((a, b) -> b.getValue() - a.getValue());
        return l.stream().limit(k).mapToInt(entry -> entry.getKey()).toArray();
    }
}
// @lc code=end
