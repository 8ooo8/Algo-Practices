/*
 * @lc app=leetcode id=34 lang=cpp
 *
 * [34] Find First and Last Position of Element in Sorted Array
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
    vector<int> searchRange(vector<int>& nums, int target) {
        /***
           * Big O: O(log n)
           * Algo: binary search
           ***/
        if (nums.empty())
            return {-1, -1};
        return {findLeftmostTargetIndex(nums, target, 0, nums.size() - 1), findRightmostTargetIndex(nums, target, 0, nums.size() - 1)};
    }

    int findRightmostTargetIndex(vector<int>& nums, int target, int leftBound, int rightBound){
        if (rightBound - leftBound <= 1){
            if (nums[rightBound] == target) return rightBound;
            if (nums[leftBound] == target) return leftBound;
            return -1;
        }

        int middle = (rightBound - leftBound) / 2 + leftBound;
        if (nums[middle] <= target) return findRightmostTargetIndex(nums, target, middle, rightBound);
        return findRightmostTargetIndex(nums, target, leftBound, middle - 1);
    }

    int findLeftmostTargetIndex(vector<int>& nums, int target, int leftBound, int rightBound){
        if (rightBound - leftBound <= 1){
            if (nums[leftBound] == target) return leftBound;
            if (nums[rightBound] == target) return rightBound;
            return -1;
        }

        int middle = (rightBound - leftBound) / 2 + leftBound;
        if (nums[middle] >= target) return findLeftmostTargetIndex(nums, target, leftBound, middle);
        return findLeftmostTargetIndex(nums, target, middle + 1, rightBound);
    }
};
// @lc code=end
