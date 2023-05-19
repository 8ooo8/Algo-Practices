/*
 * @lc app=leetcode id=1628 lang=java
 *
 * [1628] Design an Expression Tree With Evaluate Function
 */

// @lc code=start
/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
    String content;
    Node left, right;

    Node (String content) {
        this.content = content;
    }
};

class ArithmeticExpressionNode extends Node {
    static final protected Map<String, BiFunction<Integer, Integer, Integer>> COMPUTATIONS = Map.ofEntries(
                Map.entry("+", (o1, o2) -> o1 + o2),
                Map.entry("-", (o1, o2) -> o1 - o2),
                Map.entry("*", (o1, o2) -> o1 * o2),
                Map.entry("/", (o1, o2) -> o1 / o2)
            );

    ArithmeticExpressionNode (String content) {
        super(content);
    }

    public int evaluate() {
        return isOperand() ? Integer.parseInt(content) : COMPUTATIONS.get(content).apply(left.evaluate(), right.evaluate());
    }

    public boolean isOperand() {
        return content.matches("-?\\d+"); // no floating number
    }
}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<ArithmeticExpressionNode> stack = new Stack();
        for (String pf : postfix) {
            ArithmeticExpressionNode node = new ArithmeticExpressionNode(pf);
            if (!node.isOperand()) {
                node.right = stack.pop();
                node.left = stack.pop();
            }
            stack.push(node);
        }
        return stack.pop();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * ArithmeticExpressionNode expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
// @lc code=end
