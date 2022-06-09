/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
import java.util.Optional;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode emptyHead = new ListNode(0);
        ListNode cursor = emptyHead;
        int carryBit = 0;
        while (l1 != null || l2 != null || carryBit > 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carryBit;
            carryBit = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            cursor.next = newNode;
            cursor = cursor.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return emptyHead.next;
    }
}
// @lc code=end
