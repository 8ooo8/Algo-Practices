/*
 * @lc app=leetcode id=1433 lang=cpp
 *
 * [1433] Check If a String Can Break Another String
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
    bool checkIfCanBreak(string s1, string s2) {
        sort(s1.begin(), s1.end());
        sort(s2.begin(), s2.end());

        bool breakable_s1 = true, breakable_s2 = true;
        for (int i = 0; i < s1.size(); i++){
            if (breakable_s1) breakable_s1 = s1[i] <= s2[i];
            if (breakable_s2) breakable_s2 = s2[i] <= s1[i];
            if (!breakable_s1 && !breakable_s2) break;
        }
        
        return breakable_s1 || breakable_s2;
    }
};
// @lc code=end
