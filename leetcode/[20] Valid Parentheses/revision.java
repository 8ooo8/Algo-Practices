/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if ((c == ')' && (stack.isEmpty() || stack.pop() != '(')) ||
                (c == '}' && (stack.isEmpty() || stack.pop() != '{')) ||
                (c == ']' && (stack.isEmpty() || stack.pop() != '[')))
                return false;
            if (c == '(' || c == '{' || c == '[') stack.push(c);
        }
        return stack.isEmpty();
    }
}
// @lc code=end
