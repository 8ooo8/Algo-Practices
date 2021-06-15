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
    return _checkPalindromeFormation(a, b) || _checkPalindromeFormation(b, a);
};

const _checkPalindromeFormation = (left, right) => {
    let i = 0, j = left.length - 1;
    for (; i < j; i++, j--) {
        if (left[i] !== right[j]) break;
    }
    let mayFormPalindrome = true;
    for (let p = i, q = j; p < q; p++, q--) {
        if (left[p] !== left[q]) {
            mayFormPalindrome = false;
            break;
        }
    }
    if (mayFormPalindrome) return true;
    for (let p = i, q = j; p < q; p++, q--) {
        if (right[p] !== right[q]) return false;
    }
    return true;
}
// @lc code=end
