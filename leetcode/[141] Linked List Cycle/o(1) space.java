/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list.
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;
/*** [vim-leetcode] For Local Syntax Checking ***/

public class Solution {
    public boolean hasCycle(ListNode head) {
        // Algo:
        // loop through the nodes in the given linked list while reversing the pointer direction, and then
        // if it gets a cycle, it will not fall into an infinite loop and instead, it will get back to `head`
        ListNode cur = head, prev = null, next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            if (cur == head) 
                return true;
        }
        return false;
    }
}
// @lc code=end
