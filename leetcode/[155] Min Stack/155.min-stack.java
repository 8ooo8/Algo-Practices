/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {
    Stack<List<Integer>> stack;
    int min;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(Arrays.asList(val, (min = stack.isEmpty() ? val : Math.min(val, min))));
    }
    
    public void pop() {
        stack.pop();
        if (!stack.isEmpty())
            min = stack.peek().get(1);
    }
    
    public int top() {
        return stack.peek().get(0);
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end
