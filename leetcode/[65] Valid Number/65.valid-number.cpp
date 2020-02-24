/*
 * @lc app=leetcode id=65 lang=cpp
 *
 * [65] Valid Number
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
    bool isNumber(string s) {
        /*** Clear, Clean, Looslely Coupled, Extensible ***/
        enum STATE {HEAD_SPACES, SIGN, FLOAT, 
                    EXP, EXP_SIGN, EXP_INT, TRAIL_SPACES,
                    END};
        bool experiencedStates[7] = {0};
        int state = HEAD_SPACES, cursor = 0;
        
        while (state != END) {
            switch (state) {
                case HEAD_SPACES: case TRAIL_SPACES:
                {
                    experiencedStates[state] = 0;
                    for (; cursor < s.length(); cursor++){
                        if (s.at(cursor) != ' ') break;
                        experiencedStates[state] = 1;
                    }
                    state++;
                    break;
                }
                case SIGN: case EXP_SIGN:
                {
                    if ((!(state == EXP_SIGN && !experiencedStates[EXP]))
                        && cursor < s.length()
                        && (s.at(cursor) == '+' || s.at(cursor) == '-')){
                        cursor++;
                        experiencedStates[state] = 1;
                    } else { experiencedStates[state]  = 0; }
                    state++;
                    break;
                }
                case FLOAT:
                {
                    bool before = 0, dot = 0, after = 0;
                    for (; cursor < s.length(); cursor++){
                        char c = s.at(cursor);
                        if (!dot){
                            if (c >= '0' && c <= '9') before = 1;
                            else if (c == '.')        dot = 1;
                            else break;
                        }else{ 
                            if (c >= '0' && c <= '9') after = 1;
                            else break;
                        }
                    } 
                    /* Personally expected that inputs like ".1" and "1." 
                     * are not regarded as valid numbers.
                     * if (!(before && (dot ? after : 1))) return false;
                     * experiencedStates[state] = 1;
                     */
                    experiencedStates[state] = before || after;
                    state++;
                    break;
                }
                case EXP:
                {
                    if (experiencedStates[FLOAT]){
                        if (cursor < s.length() && s.at(cursor) == 'e'){
                            cursor++;
                            experiencedStates[state] = 1;
                        }
                    }
                    state++;
                    break;
                }
                case EXP_INT:
                {
                    if (experiencedStates[EXP]){
                        for (; cursor < s.length(); cursor++){
                            if (s.at(cursor) < '0' || s.at(cursor) > '9') break;
                            experiencedStates[state] = 1;
                        } 
                    }
                    state++;
                    break;
                }
            }
        };
        
        return cursor == s.length() && experiencedStates[FLOAT] 
            && !(experiencedStates[EXP] ^ experiencedStates[EXP_INT]);
    }
};
// @lc code=end
