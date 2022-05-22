/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                int operand2 = stack.pop(), operand1 = stack.pop();
                if (t.equals("+"))
                    stack.push(operand1 + operand2);
                else if (t.equals("+"))
                    stack.push(operand1 + operand2);
                else if (t.equals("-"))
                    stack.push(operand1 - operand2);
                else if (t.equals("*"))
                    stack.push(operand1 * operand2);
                else if (t.equals("/"))
                    stack.push(operand1 / operand2);
            } else
                stack.push(Integer.parseInt(t));
        }
        return stack.pop();
    }
}
// @lc code=end
