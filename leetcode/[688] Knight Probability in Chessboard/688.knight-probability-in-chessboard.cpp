/*
 * @lc app=leetcode id=688 lang=cpp
 *
 * [688] Knight Probability in Chessboard
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
#define DEPENDENCIES
#ifdef DEPENDENCIES
#include <iostream>
#include <iomanip>
#include <istream>
#include <ostream>
#include <sstream>
#include <stdio.h>
#include <vector>
#include <stack>
#include <map>
#include <unordered_map>
#include <set>
#include <unordered_set>
#include <list>
#include <forward_list>
#include <array>
#include <deque>
#include <queue>
#include <bitset>
#include <utility>
#include <algorithm>
#include <string>
#include <limits>
using namespace std;
#endif

class Solution {
public:
    double knightProbability(int N, int K, int r, int c) {
        /*** Time Complexity: O((N^2)K) ***/

        //prob[i][row][col] holds the probability of being within square, while currently at (row, col),
        //after a certain number of steps, which varies with i and time.
        double ***prob = new double**[2];
        for (int i = 0; i < 2; i++){
            prob[i] = new double*[N];
            for (int row = 0; row < N; row++)
                prob[i][row] = new double[N];
        }
    
        //write the dp table, i.e. prob
        int i = 0;
        for (int row = 0; row < N; row++){
            for (int col = 0; col < N; col++)
                prob[i][row][col] = 1; //the probability of being within sqaure after 0 step
        }
        for (int steps = 1; steps <= K; steps++){
            i = i == 0 ? 1 : 0;
            for (int row = 0; row < N; row++){
                for (int col = 0; col < N; col++){
                    auto getProbForSuchMove = [&](int horiMove, int vertMove){
                        int i2 = i == 0 ? 1 : 0; //the index of the dp table with one fewer step number
                        int rowToBe = row + horiMove, colToBe = col + vertMove;
                        if (rowToBe < 0 || rowToBe >= N || colToBe < 0 || colToBe >= N)
                            return 0.0;
                        return prob[i2][rowToBe][colToBe] / 8;
                    };
                    prob[i][row][col] = 0;
                    prob[i][row][col] += getProbForSuchMove(1, 2);
                    prob[i][row][col] += getProbForSuchMove(-1, 2);
                    prob[i][row][col] += getProbForSuchMove(1, -2);
                    prob[i][row][col] += getProbForSuchMove(-1, -2);
                    prob[i][row][col] += getProbForSuchMove(2, 1);
                    prob[i][row][col] += getProbForSuchMove(-2, 1);
                    prob[i][row][col] += getProbForSuchMove(2, -1);
                    prob[i][row][col] += getProbForSuchMove(-2, -1);
                }
            }
        }

        //return the answer from the dp table
        return prob[i][r][c];
    }

};
// @lc code=end
