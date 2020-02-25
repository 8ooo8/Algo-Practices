/*
 * @lc app=leetcode id=238 lang=cpp
 *
 * [238] Product of Array Except Self
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
    vector<int> productExceptSelf(vector<int>& nums) {
        /*** Time complexity: O(n) ***/
        /*** Space complexity(not counting the space of the output array): O(1) ***/
        vector<int> output(nums.size());

        int productOfLeftNums = 1;
        for (int i = 0; i < nums.size(); i++){
            output[i] = productOfLeftNums;
            productOfLeftNums *= nums[i];
        }

        int productOfRightNums = 1;
        for (int i = nums.size()-1; i >= 0; i--){
            output[i] *= productOfRightNums;
            productOfRightNums *= nums[i];
        }

        return output;
    }
};
// @lc code=end
