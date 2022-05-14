/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();

        if (root != null)
            q.offer(root);

        while (!q.isEmpty()) {
            int numOfNodesInCurrentLvl = q.size();

            Node node = q.poll();
            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);

            for (int i = 1; i < numOfNodesInCurrentLvl; i++) {
                Node nextNode = q.poll();
                if (nextNode.left != null)
                    q.offer(nextNode.left);
                if (nextNode.right != null)
                    q.offer(nextNode.right);
                node.next = nextNode;
                node = nextNode;
            }
        }

        return root;
    }
}
// @lc code=end
