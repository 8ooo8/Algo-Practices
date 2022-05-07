/**
 * @param {string[]} ops
 * @return {number}
 */
var calPoints = function(ops) {
    let scores = [];
    ops.forEach(o =>
        {
            if (!isNaN(o)) {
                scores.push(parseInt(o));
            } else if (o == '+') {
                scores.push(scores[scores.length - 1] + scores[scores.length - 2]);
            } else if (o == 'D') {
                scores.push(scores[scores.length - 1] * 2);
            } else if (o == 'C') {
                scores.pop();
            }
        });
    return scores.reduce((ttlScores, score) => ttlScores + score);
};

