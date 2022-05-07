/*
 * @lc app=leetcode id=1679 lang=java
 *
 * [1679] Max Number of K-Sum Pairs
 */

// @lc code=start
import java.util.Optional;
class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int n : nums) {
            m.compute(n, (num, occurences) -> Optional.ofNullable(occurences).orElse(0) + 1);
        }
        int ans = 0;
        for (int n : nums) {
            Integer nRemainOccurences = m.computeIfPresent(n, (num, occurences) -> occurences - 1);
            if (nRemainOccurences != null && nRemainOccurences >= 0) {
                Integer kMinusNRemainOccurences = m.computeIfPresent(k - n, (num, occurences) -> occurences - 1);
                if (kMinusNRemainOccurences != null && kMinusNRemainOccurences >= 0)
                    ans++;
            }
        }
        return ans;
    }
}
// @lc code=end
