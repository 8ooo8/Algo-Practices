/*
 * @lc app=leetcode id=67 lang=javascript
 *
 * [67] Add Binary
 */

// @lc code=start
/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function(a, b) {
    let l = a.length > b.length ? a : b;
    let s = a.length > b.length ? b : a;
    let result = "";
    let add1 = false;

    l = [...l].reverse().join('');
    s = [...s].reverse().join('');
    for (let i = 0; i < l.length; i++) {
        let sum = (add1 ? 1 : 0) + Number(l[i]) + (s[i] ? Number(s[i]) : 0);
        switch (sum) {
            case 0:
                add1 =  false;
                result = "0" + result;
                break;
            case 1:
                add1 = false;
                result = "1" + result;
                break;
            case 2:
                add1 = true;
                result = "0" + result;
                break;
            case 3:
                add1 = true;
                result = "1" + result;
                break;
        }
    }
    if (add1)
        result = "1" + result;

    return result;
};
// @lc code=end
