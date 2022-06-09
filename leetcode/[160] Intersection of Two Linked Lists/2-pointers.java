/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aP = headA, bP = headB;
        while (aP != bP) {
            aP = aP == null ? headB : aP.next;
            bP = bP == null ? headA : bP.next;
        }
        return aP;
    }
}
// @lc code=end
