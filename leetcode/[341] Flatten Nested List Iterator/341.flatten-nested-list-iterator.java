/*
 * @lc app=leetcode id=341 lang=java
 *
 * [341] Flatten Nested List Iterator
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> dq;

    public NestedIterator(List<NestedInteger> nestedList) {
        dq = new ArrayDeque(nestedList);
    }

    @Override
    public Integer next() {
        flatten();
        return dq.removeFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        flatten();
        return !dq.isEmpty();
    }

     // Flatten when needed instead of flattening the whole list at the beginning
    private void flatten() {
        while (!dq.isEmpty() && (!dq.getFirst().isInteger() || dq.getFirst().getInteger() == null))
            addAndFlatten(dq.removeFirst());
    }

    private void addAndFlatten(NestedInteger ni) {
        if (ni.isInteger() && ni.getInteger() != null)
            dq.offerFirst(ni);
        else if (!ni.isInteger()) {
            List<NestedInteger> l = ni.getList();
            for (int i = l.size() - 1; i >= 0; i--)
                dq.offerFirst(l.get(i)); // the time complexity will grow large if it is a linked list
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end
