// @algorithm @lc id=216 lang=java
// @title combination-sum-iii
/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        getAllCombinations(ans, k, n, new ArrayList<Integer>(), 1, 0);
        return ans;
    }

    private void getAllCombinations(List<List<Integer>> ans, int k, int n, List<Integer> components, int nextComponentMinValue, int sum) {
        if (sum > n)
            return;
        if (k == 0) {
            if (sum == n)
                ans.add(new ArrayList(components));
            return;
        }

        for (int i = nextComponentMinValue; i <= 9; i++) {
           components.add(i);
            getAllCombinations(ans, k - 1, n, components, i + 1, sum + i);
            components.remove(components.size() - 1);
        }
    }
}
// @lc code=end 
