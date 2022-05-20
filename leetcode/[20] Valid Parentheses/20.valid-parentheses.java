/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    private static Map<Character, Character> brackets = Map.of(
            ')', '(',
            ']', '[',
            '}', '{');

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char c;

        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (brackets.containsValue(c = s.charAt(i)))
                stack.push(c);
            else if (stack.isEmpty() || stack.pop() != brackets.get(c))
                return false;
        }
        return stack.isEmpty();
    }
}
// @lc code=end
