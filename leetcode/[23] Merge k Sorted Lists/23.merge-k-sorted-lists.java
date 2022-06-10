/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        ListNode emptyHead = new ListNode(), cursor = emptyHead;

        for (ListNode ln : lists)
            if (ln != null)
                q.offer(ln);

        while (!q.isEmpty()) {
            ListNode minList = q.poll();

            cursor.next = new ListNode(minList.val);
            cursor = cursor.next;

            if (minList.next != null)
                q.offer(minList.next);
        }
        
        return emptyHead.next;
    }
}
// @lc code=end
