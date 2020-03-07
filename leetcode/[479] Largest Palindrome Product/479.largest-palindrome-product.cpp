/*
 * @lc app=leetcode id=479 lang=cpp
 *
 * [479] Largest Palindrome Product
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
    int largestPalindrome(int n) {
        /***
           * let p = f1 * f2, where p is the largest palindrome, f1 and f2 are its factors -- (1)
           * let p = h * 10^n + r, where h is the first half part of p, r is the reverse of h -- (2)
           * let h = 10^n - x -- (3)
           * let f1 = 10^n - d1 -- (4.1), and f2 = 10^n - d2 -- (4.2)
           * by (1) and (2): h * 10^n + r = f1 * f2 -- (5)
           * by (5) , (3), (4.1) and (4.2):
           *    (10^n - x) * 10^n + r = (10^n - d1) * (10^n - d2)
           *    10^2n - x * 10^n + r = 10^2n - 10^n(d1 + d2) + d1 * d2
           *    10^n(d1 + d2 - x) = d1 * d2 - r
           *    A solution:
           *        d1 + d2 = x -- (6.1)
           *        d1 * d2 = r -- (6.2)
           *    (6.1) ^ 2:
           *        d1^2 + d2^2 + 2*d1*d2 = x^2
           *        d1^2 + d2^2 - 2r = x^2 - 4r (by 6.2)
           *        (d1 - d2)^2 = x^2 - 4r
           *        d1 - d2 = sqrt(x^2 - 4r)
           *        d1 = 1/2 * (sqrt(x^2 - 4r) + x) (by 6.1)
           ***/
        if (n == 1) return 9;
        int output = -1;
        for (long long int x = 1; x < pow(10, n); x++){
            //get h and r
            long long int h = pow(10, n) - x, r;
            string r_str = to_string(h);
            reverse(r_str.begin(), r_str.end());
            stringstream(r_str) >> r;

            //get x^2 - 4r
            long long int xTimesX_minus4r = x*x - 4*r;
            if (xTimesX_minus4r >= 0){
                double rt = sqrt(xTimesX_minus4r);
                double d1 = (rt + x) / 2;
                if (d1 == (long long int)d1){ //if non-integers d1 or d2, reject
                    output = (h * (long long int)pow(10, n) + r) % 1337; //get the output
                    break;
                }
            }
        }
        
        return output;
    }
};
// @lc code=end
