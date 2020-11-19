/*
 * @lc app=leetcode id=69 lang=cpp
 *
 * [69] Sqrt(x)
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
    typedef long long ll;
    int _getSqrtByTrialAndError(int input, ll trial_from, ll trial_to){
        auto isSqrt = [=](ll  theSqrt){
            return theSqrt * theSqrt <= input && (theSqrt + 1) * (theSqrt + 1) > input;
        };

        if (trial_to - trial_from <= 1){
            if (isSqrt(trial_to)) return trial_to;
            return trial_from;
        }

        ll  trial_middle = (trial_to - trial_from) / 2 + trial_from;
        if (isSqrt(trial_middle)) return trial_middle;

        ll  middle_square = trial_middle * trial_middle;
        if (middle_square > input) return _getSqrtByTrialAndError(input, trial_from, trial_middle - 1);
        return _getSqrtByTrialAndError(input, trial_middle + 1, trial_to);
    }

public:
    int mySqrt(int x) {
        /*
           * Time complexity: Big O(logn)
           * Algo: Binary search
           */
        return _getSqrtByTrialAndError(x, 1, x);
    }
};
// @lc code=end
