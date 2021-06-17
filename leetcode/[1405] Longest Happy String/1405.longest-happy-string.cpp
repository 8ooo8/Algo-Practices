/*
 * @lc app=leetcode id=1405 lang=cpp
 *
 * [1405] Longest Happy String
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
    string longestDiverseString(int a, int b, int c) {
        auto cmp = [](const pair<int, char>& a, const pair<int, char>& b) { return a.first < b.first; };
        priority_queue<pair<int, char>, vector<pair<int, char>>, decltype(cmp)> pq(cmp);
        if (a) pq.push({a, 'a'});
        if (b) pq.push({b, 'b'});
        if (c) pq.push({c, 'c'});

        string result = "";
        while (!pq.empty()){
            auto top = pq.top();
            pq.pop();
            if (result.length() >= 2 && result[result.length() - 1] == top.second && result[result.length() - 2] == top.second) {
                if (pq.empty()) break;
                auto top2 = pq.top();
                pq.pop();
                result.push_back(top2.second);
                top2.first--;
                if (top2.first) pq.push(top2);
                pq.push(top);
            } else {
                result.push_back(top.second);
                top.first--;
                if (top.first) pq.push(top);
            }
        }
        return result;
    }
};
// @lc code=end
