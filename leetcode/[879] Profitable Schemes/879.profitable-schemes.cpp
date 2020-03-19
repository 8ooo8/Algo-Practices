/*
 * @lc app=leetcode id=879 lang=cpp
 *
 * [879] Profitable Schemes
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

#define MAX_G 100
#define MAX_P 100
#define MOD (int)1e9 + 7

class Solution {
public:
    int profitableSchemes(int G, int P, vector<int>& group, vector<int>& profit) {
        /*** Time Complexity: O(number-of-crimes * P * G), Space Complexity: O(P * G) ***/
        size_t numOfCrimes = profit.size();
        //schemesDP[i] refers to the previous or latest dp table;
        //schemesDP[i][p][g] has a value of the number of schemes that generate p profit using g gang members.
        int schemesDP[2][MAX_P + 1][MAX_G + 1] = {0};
        schemesDP[0][0][0] = 1;
        int output = 0;
        
        for (int i = 0; i < profit.size(); i++){
            int (*prevDP)[MAX_G + 1] = schemesDP[i % 2];
            int (*currDP)[MAX_G + 1] = schemesDP[i % 2 == 0 ? 1 : 0];
            
            //update currDP
            int addP = profit[i], addG = group[i];
            for (int p = 0; p <= P; p++)
                for (int g = 0; g <= G; g++)
                    currDP[p][g] = prevDP[p][g];
            for (int p = 0; p <= P; p++){
                int newP = min(p + addP, P);
                for (int g = 0; g <= G - addG; g++){
                    int newG = g + addG;
                    currDP[newP][newG] += prevDP[p][g];
                    currDP[newP][newG] %= MOD;
                }
            }
        }

        //get the solution by summing the number of schemes generating P profit
        for (int g = 1; g <= G; g++){
            output += schemesDP[profit.size() % 2][P][g];
            output %= MOD;
        }

        return output;
    }
};
// @lc code=end
