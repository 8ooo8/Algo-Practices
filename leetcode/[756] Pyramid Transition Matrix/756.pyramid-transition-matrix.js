/*
 * @lc app=leetcode id=756 lang=javascript
 *
 * [756] Pyramid Transition Matrix
 */

// @lc code=start
/**
 * @param {string} bottom
 * @param {string[]} allowed
 * @return {boolean}
 */
var pyramidTransition = function(bottom, allowed) {
    allowed = allowed.reduce((map, triple) => {
        const mapKey = triple.substr(0, 2);
        map[mapKey] = map[mapKey] || [];
        map[mapKey].push(triple[2]);
        return map;
    }, {});

    return _DFS(bottom.split(''), allowed);
};

const _DFS = (bottom, allowed) => {
    if (bottom.length === 1) return true;
    bottom = bottom.map((_, i) => bottom[i - 1] + bottom[i]).slice(1);

    let nextBottom = bottom.map(key => allowed[key]);
    if (nextBottom.some(s => !s || s.length === 0)) return false;

    const nextBottomCharPtr = nextBottom.map(_ => 0);
    const tryAllNextBottomCombinations = (i) => {
        if (i >= nextBottom.length) {
            return _DFS(nextBottomCharPtr.map((p, i) => nextBottom[i][p]), allowed);
        }
        for (let j = 0; j < nextBottom[i].length; j++) {
            if (tryAllNextBottomCombinations(i + 1)) return true;
            nextBottomCharPtr[i]++;
        };
        nextBottomCharPtr[i] = 0;
    };
    return tryAllNextBottomCombinations(0) || false;
}
// @lc code=end
