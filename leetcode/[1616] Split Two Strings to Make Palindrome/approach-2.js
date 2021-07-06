/*
 * @lc app=leetcode id=1616 lang=javascript
 *
 * [1616] Split Two Strings to Make Palindrome
 */

// @lc code=start
/**
 * @param {string} a
 * @param {string} b
 * @return {boolean}
 */
var checkPalindromeFormation = function(a, b) {
    const helper = (a, b) => {
        const cp = _getCentralPalindrome(a);
        const [left, right] = cp ? cp : [a.length / 2, a.length / 2 - 1];
        const p = _getCentralPalindrome(a.slice(0, left).concat(b.slice(right + 1)));
        const p2 = _getCentralPalindrome(b.slice(0, left).concat(a.slice(right + 1)));
        return (p && p[0] === 0) || (p2 && p2[0] === 0);
    }
    return Boolean(helper(a, b) || helper(b, a)); //it checks if the returned value is false but not if evaluated to false
};

const _getCentralPalindrome = function(a) {
    if (a.length === 0) return [0, 0];
    let left, right;
    if (a.length % 2) {
        left = right = a.length / 2 - 0.5;
    } else {
        right = a.length / 2;
        left = right - 1;
    }
    if (a[left] !== a[right]) return null;
    while (left - 1 >= 0 && a[left - 1] === a[right + 1]) {
        left--, right++;
    }
    return [left, right];
}
// @lc code=end
