/*
 * @lc app=leetcode id=35 lang=cpp
 *
 * [35] Search Insert Position
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
private:
    int _getInsertPosition(const vector<int>& nums, int from, int to, int target){
        if (to - from <= 1){
            if (nums[from] >= target) return from;
            return to;
        }

        int middle = (to - from) / 2 + from;
        if (nums[middle] == target) return middle;
        if (nums[middle] < target) return _getInsertPosition(nums, middle, to, target);
        return _getInsertPosition(nums, from, middle, target);
    }

public:
    int searchInsert(vector<int>& nums, int target) {
        return _getInsertPosition(nums, 0, nums.size(), target);
    }
};
// @lc code=end
