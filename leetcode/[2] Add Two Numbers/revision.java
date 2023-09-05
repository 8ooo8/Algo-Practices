/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

// public class ListNode {
    // int val;
    // ListNode next;
    // ListNode() {}
    // ListNode(int val) { this.val = val; }
    // ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }
class Solution {
    private void addTwoNumbers(ListNode l1, ListNode l2, ListNode sum, int carry) {
        if (l1 == null && l2 == null && carry == 0) return;

        int added = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
        sum.next = new ListNode(added % 10);
        addTwoNumbers(l1 == null ? l1 : l1.next, l2 == null ? l2 : l2.next, sum.next, added / 10);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        addTwoNumbers(l1, l2, res, 0);
        return res.next;
    }
}
// @lc code=end
