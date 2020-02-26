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
        /*** Time complexity: O(n) ***/
        int output = nums[0];
        int non0PartStartIdx = 0, non0PartEndIdx;
        vector<int> negaNumIdx;

        for (int i = 0; i < nums.size(); i++){
            int num = nums[i];
            if (num < 0)
                negaNumIdx.push_back(i);
            //divide the input into non-zero parts 
            if (num == 0 || i == nums.size() - 1){
                non0PartEndIdx = i - (num == 0 ? 1 : 0);
                int maxProduct;
                auto getProduct = [&nums](int startIdx, int endIdx){
                    int product = nums[startIdx];
                    for (int i = startIdx + 1; i <= endIdx; i++)
                        product *= nums[i];
                    return product;
                };
                if (negaNumIdx.size() % 2 == 0){
                    //if even number of -ve numbers in the current non-zero part,
                    //multiply all the numbers to obtain the max product.
                    maxProduct = getProduct(non0PartStartIdx, non0PartEndIdx);
                }else{
                    //if odd number of -ve numbers ...
                    int startIdx = negaNumIdx.front() + 1, endIdx = non0PartEndIdx;
                    if (startIdx > non0PartEndIdx) startIdx = non0PartEndIdx;
                    maxProduct = getProduct(startIdx, endIdx);

                    startIdx = non0PartStartIdx, endIdx = negaNumIdx.back() - 1;
                    if (endIdx < non0PartStartIdx) endIdx = non0PartStartIdx;
                    maxProduct = max(maxProduct, getProduct(startIdx, endIdx));
                } 
                
                output = max(output, maxProduct);
                if (num == 0) output = max(output, 0);

                non0PartStartIdx = i + 1;
                negaNumIdx.clear();
            }
        }
        
        return output;
    }
};
// @lc code=end
