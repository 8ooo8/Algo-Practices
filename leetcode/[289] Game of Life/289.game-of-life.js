/*
 * @lc app=leetcode id=289 lang=javascript
 *
 * [289] Game of Life
 */

// @lc code=start
/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var gameOfLife = function(board) {
    for (let i = 0; i < board.length; i++)
        for (let j = 0; j < board[0].length; j++)
            if (willBeAlive(board, i, j))
                board[i][j] |= 0b10;

    for (let i = 0; i < board.length; i++)
        for (let j = 0; j < board[0].length; j++)
            board[i][j] >>>= 1;
};

const willBeAlive = (board, i, j) => {
    let aliveNeigh = 0;
    for (let p = -1; p < 2; p++)
        for (let q = -1; q < 2; q++)
            if (p != 0 || q != 0) {
                aliveNeigh += (board[i + p]?.[j + q] & 1) ? 1 : 0;
            }
    return board[i][j] ? (aliveNeigh >= 2 && aliveNeigh <= 3 ? 1 : 0) : (aliveNeigh === 3 ? 1 : 0);
};
// @lc code=end
