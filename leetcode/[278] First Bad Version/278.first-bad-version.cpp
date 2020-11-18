/*
 * @lc app=leetcode id=278 lang=cpp
 *
 * [278] First Bad Version
 */

// @lc code=start
// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

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
    int _searchFirstBadVersion(int oldestVer, int latestVer){
        if (latestVer - oldestVer <= 1){
            if (isBadVersion(oldestVer)) return oldestVer;
            return latestVer;
        }

        int middleVer = (latestVer - oldestVer) / 2  + oldestVer;
        int middleVerIsBad = isBadVersion(middleVer);
        if (middleVerIsBad)
            return _searchFirstBadVersion(oldestVer, middleVer);
        return _searchFirstBadVersion(middleVer + 1, latestVer);
    }
public:
    int firstBadVersion(int n) {
        /***
           * Time complexity: Big O(logn)
           * Algo: binary search
           ***/
        return _searchFirstBadVersion(1, n);
    }
};
// @lc code=end
