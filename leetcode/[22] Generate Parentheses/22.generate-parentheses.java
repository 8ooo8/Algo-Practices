/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n, 0, 0, new StringBuilder(), ans);
        return ans;
    }

    private void helper(int n, int usedOpenings, int usedClosings, StringBuilder combination, List<String> ans) {
        if (usedOpenings == n && usedClosings == n)
            ans.add(combination.toString());
        if (usedOpenings < n) {
            helper(n, usedOpenings + 1, usedClosings, combination.append('('), ans);
            combination.deleteCharAt(combination.length() - 1);
        }
        if (usedClosings < usedOpenings) {
            helper(n, usedOpenings, usedClosings + 1, combination.append(')'), ans);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
// @lc code=end
