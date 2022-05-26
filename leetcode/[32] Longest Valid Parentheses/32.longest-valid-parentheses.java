/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> chars = new Stack<>();
        Stack<Integer> idx = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!chars.isEmpty() && chars.peek() == '(' && c == ')') {
                chars.pop();
                idx.pop();
            } else {
                chars.push(c);
                idx.push(i);
            }
        } 

        if (chars.isEmpty())
            return s.length();
        int ans = 0;
        int end = s.length() - 1;
        while (!idx.isEmpty()) {
            int start = idx.pop();
            ans = Math.max(ans, end - start);
            end = start - 1;
        }
        return Math.max(ans, end + 1);
    }

}
// @lc code=end
