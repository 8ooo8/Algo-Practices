/*
 * @lc app=leetcode id=566 lang=javascript
 *
 * [566] Reshape the Matrix
 */

// @lc code=start
/**
 * @param {number[][]} mat
 * @param {number} r
 * @param {number} c
 * @return {number[][]}
 */
var matrixReshape = function(mat, r, c) {
    if (mat.length * mat[0].length !== r * c) return mat;
    const reshaped = Array(r).fill().map(_ => Array(c));
    let i = 0, j = 0;
    mat.forEach(row => row.forEach(v => {
        reshaped[i][j] = v;
        if (++j >= c) {
            i++;
            j = 0;
        }
    }));
    return reshaped;
};

// @lc code=end
