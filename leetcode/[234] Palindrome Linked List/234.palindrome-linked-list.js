/*
 * @lc app=leetcode id=234 lang=javascript
 *
 * [234] Palindrome Linked List
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
 * @return {boolean}
 */
var isPalindrome = function(head) {
    const str = _getStrRepresentation(head);
    const firstHalfStr = str.slice(0, Math.floor(str.length / 2));
    const secondHalfStr = str.slice(Math.floor(str.length / 2) + (str.length % 2));
    return firstHalfStr === secondHalfStr.split('').reverse().join('');
};

const _getStrRepresentation = head => {
    if (!head)
        return '';
    return head.val + _getStrRepresentation(head.next);
}
// @lc code=end
