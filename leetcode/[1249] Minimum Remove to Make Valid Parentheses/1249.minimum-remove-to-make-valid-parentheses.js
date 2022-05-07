/*
 * @lc app=leetcode id=1249 lang=javascript
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var minRemoveToMakeValid = function(s) {
    const leftParen = [];
    const rightParen = [];
    for (let i = 0, c = s[i]; i < s.length; i++, c = s[i])
    {
        switch (c)
        {
            case '(':
                leftParen.push(i);
                break;
            case ')':
                if (leftParen.length > 0)
                    leftParen.pop();
                else
                    rightParen.push(i);
                break;
        }
    }
    
    let validStr = '';
    for (let i = 0, l = 0, r = 0; i < s.length; i++)
    {
        if (i == leftParen[l])
            l++;
        else if (i == rightParen[r])
            r++;
        else
            validStr += s[i];
    }

    return validStr;
};
// @lc code=end
