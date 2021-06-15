/*
 * @lc app=leetcode id=127 lang=javascript
 *
 * [127] Word Ladder
 */

// @lc code=start
/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    wordList = wordList.map((w, i) => ({val: w, i: i}));
    const visited = Array(wordList).fill(false);
    const queue = [{val: beginWord, i: undefined, steps: 1}];
    while (queue.length > 0) {
        const word = queue[0];
        queue.shift();
        if (visited[word.i]) continue;
        if (word.val == endWord) return word.steps;
        queue.push.apply(queue, (wordList.filter(w => !visited[w.i] && isWithOneLetterDiff(w.val, word.val))
            .map(w => Object.assign(w, {steps: w.steps ? w.steps : word.steps + 1}))));
        if (!isNaN(word.i)) visited[word.i] = true;
    }
    return 0;
};

const isWithOneLetterDiff = (a, b) => {
    let diff = 0;
    for (let i = 0; i < a.length; i++){
        if (a[i] !== b[i]) diff++;
        if (diff > 1) return false;
    }
    return diff === 1 ? true : false;
}
// @lc code=end
