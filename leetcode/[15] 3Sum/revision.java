/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if (nums.length < 3) return new ArrayList<>(result);

        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < sortedNums.length - 2; i++) {
            int j = i + 1;
            int k = sortedNums.length - 1;
            while (k > j) {
                int sum = sortedNums[i] + sortedNums[j] + sortedNums[k];
                if (sum == 0)
                    result.add(Arrays.asList(sortedNums[i], sortedNums[j++], sortedNums[k--]));
                else if (sum < 0)
                    j++;
                else
                    k--;
            }
        }
        return new ArrayList<>(result);
    }

    private void _2sum(int[] sortedNums, int p1, int p2, List<List<Integer>> result) {
        
    }
}
// @lc code=end
