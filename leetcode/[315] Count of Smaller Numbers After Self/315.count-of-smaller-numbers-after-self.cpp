/*
 * @lc app=leetcode id=315 lang=cpp
 *
 * [315] Count of Smaller Numbers After Self
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
    struct Node{
        int val;
        Node *left, *right;
        int child_num = 0;

        Node(int val, int child_num = 0, Node *left = 0, Node *right = 0):
             val(val), left(left),  right(right),  child_num(child_num){}
    };

    void _add_node(Node* bst, Node* new_node, int& smaller_count){
        bst->child_num++;
        if (bst->val < new_node->val){
            smaller_count += 1 + (bst->left ? 1 + bst->left->child_num : 0);
            if (bst->right)
                _add_node(bst->right, new_node, smaller_count);
            else
                bst->right = new_node;
        }else{
            if (bst->left)
                _add_node(bst->left, new_node, smaller_count);
            else
                bst->left = new_node;
        }
    }

public:
    vector<int> countSmaller(vector<int>& nums) {
        /***
           * Data structure / algorithm: BST
           ***/
        vector<int> count;
        if (nums.empty()) return count;

        Node* bst = new Node(nums.back());
        count.push_back(0);

        for_each(nums.crbegin() + 1, nums.crend(), [&](int val){
                int smaller_count = 0;
                _add_node(bst, new Node(val), smaller_count);
                count.push_back(smaller_count);
                });
        reverse(count.begin(), count.end());

        return count;
    }
};
// @lc code=end
