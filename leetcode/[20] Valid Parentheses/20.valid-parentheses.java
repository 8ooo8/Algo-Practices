/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = Map.of(')', '(', ']', '[', '}', '{');
        Stack<Character> stack = new Stack<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            if (brackets.containsValue(c = s.charAt(i))) stack.push(c);
            else if (stack.isEmpty() || stack.pop() != brackets.get(c)) return false;
        }
        return stack.isEmpty();
    }
}
// @lc code=end
