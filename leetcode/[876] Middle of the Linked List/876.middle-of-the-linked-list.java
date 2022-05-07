/*
 * @lc app=leetcode id=876 lang=java
 *
 * [876] Middle of the Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private int getNumOfNode(ListNode head) {
        if (head == null) return 0;
        return getNumOfNode(head.next) + 1;
    }
    private ListNode getNthNode(ListNode head, int n) {
        if (n == 0) return head;
        return getNthNode(head.next, n - 1);
    }
    public ListNode middleNode(ListNode head) {
        final int numOfNode = getNumOfNode(head);
        return getNthNode(head, numOfNode / 2);
    }
}
// @lc code=end
