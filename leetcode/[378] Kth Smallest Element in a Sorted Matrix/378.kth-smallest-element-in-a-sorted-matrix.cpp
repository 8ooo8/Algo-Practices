/*
 * @lc app=leetcode id=378 lang=cpp
 *
 * [378] Kth Smallest Element in a Sorted Matrix
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
    typedef pair<int, int> XY;
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        auto cmp = [&](const XY& a, const XY& b){ return matrix[a.first][a.second] > matrix[b.first][b.second]; };
        priority_queue<XY, std::vector<XY>, decltype(cmp)> pq(cmp);
        pq.push({0, 0});
        int nThSmallElement = 0;
        int smallElement;
        bool visited[300][300] = {{false}};
        while (nThSmallElement < k) {
            auto [x, y] = pq.top();
            pq.pop();
            if (visited[x][y]) continue;
            visited[x][y] = true;
            nThSmallElement++;
            smallElement = matrix[x][y];
            if (x + 1 < matrix.size()) pq.push({x + 1, y});
            if (y + 1 < matrix[x].size()) pq.push({x, y + 1});
        }
        return smallElement;
    }
};
// @lc code=end
