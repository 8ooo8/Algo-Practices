/*
 * @lc app=leetcode id=1410 lang=javascript
 *
 * [1410] HTML Entity Parser
 */

// @lc code=start
/**
 * @param {string} text
 * @return {string}
 */
var entityParser = function(text) {
    let parsing = [];
    let parsed = '';
    const parseList = [{from: '&quot;', to: '"'}, {from: '&apos;', to: '\''}, {from: '&amp;', to: '&'},
                        {from: '&gt;', to: '>'}, {from: '&lt;', to: '<'}, {from: '&frasl;', to: '/'}];
    let parseListPtr = Array(6).fill(0);
    const parse = () => {
        const c = parsing[parsing.length - 1];
        let maxPtr = 0;
        for (let i = 0; i < parseList.length; i++) {
            if (parseList[i].from[parseListPtr[i]] === c) {
                parseListPtr[i]++;
                if (parseListPtr[i] === parseList[i].from.length) {
                    parsed += parseList[i].to;
                    parsing = [];
                    parseListPtr = parseListPtr.map(_ => 0);
                    break;
                }
            } else {
                parseListPtr[i] = parseList[i].from[0] === c ? 1 : 0;
            }
            maxPtr = Math.max(maxPtr, parseListPtr[i]);
        };
        if (maxPtr < parsing.length) {
            parsed += parsing.slice(0, parsing.length - maxPtr).join('');
            parsing = parsing.slice(parsing.length - maxPtr);
        }
    };
    text.split('').forEach(c => {
        parsing.push(c);
        parse();
    });
    parsed += parsing.join('');
    return parsed;
};
// @lc code=end
