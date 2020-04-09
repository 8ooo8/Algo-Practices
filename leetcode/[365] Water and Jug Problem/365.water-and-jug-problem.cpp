/*
 * @lc app=leetcode id=365 lang=cpp
 *
 * [365] Water and Jug Problem
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
    bool canMeasureWater(int x, int y, int z) {
        /***
           * Math solution - GCD approach
           * 
           * Use below formula to represent the total litres of water.
           * let t = mx + ny, where m and n are integers.
           * > t is the total litres of water.
           * > When an empty jug-x is filled, m += 1; when a full jug-x is emptied, m -= 1; n is similar.
           * > When water is transferred between jugs, this has no immediate effect to the total litres
           *   water but may make a jug not full or empty.
           * > When a jug that is neither full nor empty is filled or emptied:
           *    Let the total litres of water right before the filling or the emptying be
           *        t1 = m1 * x + n1 * y.
           *    Observed that simply filling or emptying a jug cannot lead to a jug being neither full
           *        nor empty. A jug being neither full nor empty must be a result of water transfer.
           *    Observed that a water transfer may lead to such a phenomenon by 2 ways:
           *        (1) transferring water from jug-A to jug-B and the total litres of water does
           *            not reach the limit of jug-B (i.e. jug-B will not be full),
           *        (2) transferring water from jug-A to jug-B and the total litres of water exceeds
           *            the maximum limit of jug-B (i.e. jug-B will be full).
           *        If it is case (1) and it is going to fill jug-B, the resulted total litres of water
           *            can be represented by t2 = B, where B is the capacity of jug-B;
           *        If it is case (1) and it is going to empty jug-B, the resulted total litres of water
           *            can be represented by t2 = 0;
           *        If it is case (2) and it is going to fill jug-B, the resulted total litres of water
           *            can be represented by t2 = t1;
           *        If it is case (2) and it is going to empty jug-B, the resulted total litres of water
           *            can be represented by t2 = t1 - B, where B is the capacity of jug-B.
           *    (Please note that the above 4 expressions can all be represented by the formula.)
           *
           * > For example, 4 = -2 * 3 + 2 * 5.
           *   According to the defintion of the formula, this means:
           *       filling the jug-5 twice and emptying the full jug-3 twice.
           *   The steps to achieve 4 litres of water is shown as below:
           *       (1) fill jug-5 => (2) transfer from jug-5 to jug-3 => (3) empty jug-3 =>
           *       (4) transfer jug-5 to jug-3 (at this moment, jug-3 has 2 litres of water, jug-5 0) =>
           *       (5) fill jug-5 => (6) transfer from jug-5 to jug-3 => (7) empty jug-3
           *       (at this moment, jug-5 has 4 litres of water)
           *
           * According to Bézout's identity, which is
           *    "Let a and b be integers with greatest common divisor d. Then, there exists integers x and
           *    y such that ax + by = d. More generally, the integers of the form ax + by are exactly the 
           *    multiples of d",
           *    z is achievable if it is a multiples of the greatest common divisor of x and y.
           ***/
        return z == 0 || (x + y >= z && z % gcd(x, y) == 0);
    }
private:
    int gcd(int x, int y) { return y == 0 ? x : gcd(y, x % y); }
};
// @lc code=end
