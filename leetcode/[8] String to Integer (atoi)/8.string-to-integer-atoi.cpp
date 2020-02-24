/*
 * @lc app=leetcode id=8 lang=cpp
 *
 * [8] String to Integer (atoi)
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

#define LOWLIMIT -2147483648
#define UPLIMIT 2147483647

class Solution {
public:
    int myAtoi(string str) {
        /*** Clear, Clean ***/
        enum STATE { SPACES, SIGN, ZEROES, DIGITS };
        int state = 0;
        int output = 0, cursor = 0;
        bool negative = 0;

        if (state == SPACES){
            for (; cursor < str.length(); cursor++){
                if (str.at(cursor) !=  ' ') break;
            }
            state++;
        }
        if (state == SIGN){
            if (cursor != str.length()){
                char c = str.at(cursor);
                if (c == '-' || c == '+'){
                    negative = c == '-';
                    cursor++;
                }
            }
            state++;
        }
        if (state == ZEROES){
            for (; cursor < str.length(); cursor++){
                if (str.at(cursor) != '0') break;
            }
            state++;
        }
        if (state == DIGITS){
            const int ONE_OVER_TEN_LIMIT_MAGNITUDE = UPLIMIT / 10;
            const int LIMIT_MAGNITUDE_LAST_DIGIT = negative ? 8 : 7;
            char c;
            for (; cursor < str.length(); cursor++){
                c = str.at(cursor);
                if (c >= '0' && c <= '9'){
                    if (output > ONE_OVER_TEN_LIMIT_MAGNITUDE ||
                       (output == ONE_OVER_TEN_LIMIT_MAGNITUDE && 
                        c-'0' >= LIMIT_MAGNITUDE_LAST_DIGIT)){
                        output = negative ? LOWLIMIT : UPLIMIT;
                        break;
                    }else{
                        output = output*10 - '0' + c;
                    }
                }else{
                    if (negative) output *= -1;
                    break;
                }
                if (negative && cursor == str.length()-1) output *= -1;
            }
        }
        
        return output;
    }
};
// @lc code=end
