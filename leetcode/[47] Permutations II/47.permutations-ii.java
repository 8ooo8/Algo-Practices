/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, new boolean[nums.length], new int[nums.length], 0, ans);
        return ans;
    }

    private void helper(int[] nums, boolean[] visited, int[] permutation, int numOfPermuted, List<List<Integer>> ans) {
        if (numOfPermuted == nums.length) {
            ans.add(IntStream.of(permutation).boxed().collect(Collectors.toList()));
            return;
        }

        // check the duplications at permutation[numOfPermuted], instead of checking the duplications in the end for the completed permutations,
        // to improve the program performance for having many items in nums (though in this question, at max 8 items)
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || used.contains(nums[i]))
                continue;
            visited[i] = true;
            permutation[numOfPermuted] = nums[i];
            used.add(nums[i]);
            helper(nums, visited, permutation, numOfPermuted + 1, ans);
            visited[i] = false;
        }

    }
}
// @lc code=end
