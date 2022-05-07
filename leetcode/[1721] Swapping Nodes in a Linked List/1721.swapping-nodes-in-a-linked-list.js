/*
 * @lc app=leetcode id=1721 lang=javascript
 *
 * [1721] Swapping Nodes in a Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var swapNodes = function(head, k) {
    const getNumOfNodes = (head) => {
        return head == null ? 0 : getNumOfNodes(head.next) + 1;
    }
    const numOfNodes = getNumOfNodes(head);

    const kFromEnd = numOfNodes - k + 1;
    let kValue, kFromEndValue;
    let cursor = head;
    for (let i = 1; i <= kFromEnd || i <= k; i++) {
        if (i == k)
            kValue = cursor.val;
        if (i == kFromEnd)
            kFromEndValue = cursor.val;
        
        cursor = cursor.next;
    }

    cursor = head;
    for (let i = 1; i <= kFromEnd || i <= k; i++) {
        if (i == k)
            cursor.val = kFromEndValue;
        else if (i == kFromEnd)
            cursor.val = kValue;
        
        cursor = cursor.next;
    }

    return head;
};
// @lc code=end
