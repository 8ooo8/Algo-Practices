/*
 * @lc app=leetcode id=152 lang=cpp
 *
 * [152] Maximum Product Subarray
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
    int maxProduct(vector<int>& nums) {
        //dp[i].first: the largest product which has nums[i] and possibly also previous item(s) as factor(s)
        //dp[i].second: the smallest product which has nums[i] and possibly also previous item(s) as factor(s)
        vector<pair<int, int>> dp(nums.size());
        int output;

        dp[0] = {nums[0], nums[0]};
        output = nums[0];
        for (int i = 1; i < nums.size(); i++){
            dp[i].first = max(max(nums[i], nums[i]*dp[i-1].first), nums[i]*dp[i-1].second);
            dp[i].second = min(min(nums[i], nums[i]*dp[i-1].first), nums[i]*dp[i-1].second);
            output = max(output, dp[i].first);
        }

        return output;
    }
};
// @lc code=end
