/*
 * @lc app=leetcode id=883 lang=cpp
 *
 * [883] Projection Area of 3D Shapes
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
    int projectionArea(vector<vector<int>>& grid) {
        int topShadow = 0, frontShadow = 0, sideShadow = 0;
        vector<int> greatestHeightOnRows, greatestHeightOnCols;

        for (int rowIdx = 0; rowIdx < grid.size(); rowIdx++){
            vector<int> row = grid[rowIdx];
            greatestHeightOnRows.resize(greatestHeightOnRows.size() + 1, 0);
            for (int colIdx = 0; colIdx < row.size(); colIdx++){
                int height = row[colIdx];
                if (height > 0) topShadow++;
                greatestHeightOnRows[rowIdx] = max(greatestHeightOnRows[rowIdx], height);
                if (greatestHeightOnCols.size() <= colIdx + 1)
                    greatestHeightOnCols.resize(greatestHeightOnCols.size() + 1, 0);
                greatestHeightOnCols[colIdx] = max(greatestHeightOnCols[colIdx], height);
            }
        }
        for (auto height = greatestHeightOnRows.cbegin(); height != greatestHeightOnRows.cend(); height++)
            frontShadow += *height;
        for (auto height = greatestHeightOnCols.cbegin(); height != greatestHeightOnCols.cend(); height++)
            sideShadow += *height;
       
        return topShadow + frontShadow + sideShadow;
    }
};
// @lc code=end
