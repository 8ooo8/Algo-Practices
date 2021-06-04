/*
 * @lc app=leetcode id=147 lang=javascript
 *
 * [147] Insertion Sort List
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
 * @return {ListNode}
 */
var insertionSortList = function(head) {
    let sortListHead = new ListNode(head.val);

    let unsortedListCursor = head.next;
    while (unsortedListCursor){
        const toInsert = new ListNode(unsortedListCursor.val);

        if (toInsert.val < sortListHead.val) {
            // prepend to the insertionSortList
            toInsert.next = sortListHead;
            sortListHead = toInsert;
        } else {
            let sortedListCursor = sortListHead;
            while (sortedListCursor) {
                const next = sortedListCursor.next;

                // append to the insertionSortList
                if (!next) {
                    sortedListCursor.next = toInsert;
                    break;
                }
                // insert in the middle of the insertionSortList
                if (next.val >= toInsert.val && sortedListCursor.val <= toInsert.val) {
                    toInsert.next = next;
                    sortedListCursor.next = toInsert;
                    break;
                }

                sortedListCursor = sortedListCursor.next;
            }
        }
        unsortedListCursor = unsortedListCursor.next;
    }
    return sortListHead;
};
// @lc code=end
