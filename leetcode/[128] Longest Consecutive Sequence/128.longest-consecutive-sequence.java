/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> numsSet = IntStream.of(nums).boxed().collect(Collectors.toSet());
        Set<Integer> visitedSet = new HashSet<>();
        for (int n : nums) {
            if (visitedSet.contains(n))
                continue;
            visitedSet.add(n);

            int consecutiveCount = 1;
            int leftConsecutive = n - 1, rightConsecutive = n + 1;
            while (numsSet.contains(leftConsecutive)) {
                consecutiveCount++;
                visitedSet.add(leftConsecutive--);
            }
            while (numsSet.contains(rightConsecutive)) {
                consecutiveCount++;
                visitedSet.add(rightConsecutive++);
            }
            ans = Math.max(ans, consecutiveCount);
        }
        return ans;
    }
}
// @lc code=end
