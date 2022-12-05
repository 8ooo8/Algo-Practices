/*
 * @lc app=leetcode id=2130 lang=java
 *
 * [2130] Maximum Twin Sum of a Linked List
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
    public int pairSum(ListNode head) {
        int mid = countElements(head) / 2;
        
        // reverse the first half of the linked list
        ListNode pre = null, cur = head, next = null;
        for (int i = 0; i < mid; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode firstHalf = pre, nextHalf = cur;

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < mid; i++) {
            ans = Math.max(firstHalf.val + nextHalf.val, ans);
            firstHalf = firstHalf.next;
            nextHalf = nextHalf.next;
        }
        return ans;
    }

    private int countElements(ListNode head) {
        return head == null ? 0 : countElements(head.next) + 1;
    }
}
// @lc code=end
