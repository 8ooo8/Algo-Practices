/*
 * @lc app=leetcode id=1220 lang=javascript
 *
 * [1220] Count Vowels Permutation
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var countVowelPermutation = function(n) {
    const follows = {a: ['e'], e: ['a', 'i'], i: ['a', 'e', 'o', 'u'], o: ['i', 'u'], u: ['a']};
    let lastVowels = {a: 1, e: 1, i: 1, o: 1, u: 1};
    for (let i = 1; i < n; i++) {
        let newLastVowels = {a: 0, e: 0, i: 0, o: 0, u: 0};
        Object.keys(lastVowels).forEach(v => {
            follows[v].forEach(newV => {
                newLastVowels[newV] += lastVowels[v];
                newLastVowels[newV] %= 1000_000_007;
            });
        });
        lastVowels = newLastVowels;
    }
    return Object.values(lastVowels).reduce((sum, count) => (sum + count) % 1000_000_007);
};
// @lc code=end
