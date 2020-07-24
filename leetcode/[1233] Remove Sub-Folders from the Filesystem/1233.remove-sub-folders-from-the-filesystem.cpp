/*
 * @lc app=leetcode id=1233 lang=cpp
 *
 * [1233] Remove Sub-Folders from the Filesystem
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
    vector<string> removeSubfolders(vector<string>& folder) {
        sort(folder.begin(), folder.end());
        
        vector<string> result;
        result.push_back(folder[0]);
        for (int i = 1; i < folder.size(); i++){
            string last = result.back(), to_add = folder[i];
            if (to_add.substr(0, last.size() + 1).compare(last + "/") != 0)
                result.push_back(to_add);
            // bool is_subfolder = to_add.size() > last.size();
            // for (int j = 0; is_subfolder && j < last.size(); j++){
                // if (to_add[j] != last[j]){
                    // is_subfolder = false;
                // }
            // }
            // is_subfolder = is_subfolder ? to_add[last.size()] == '/' : 0;
            // if (!is_subfolder) result.push_back(to_add);
        }
        
        return result;
    }
};
// @lc code=end
