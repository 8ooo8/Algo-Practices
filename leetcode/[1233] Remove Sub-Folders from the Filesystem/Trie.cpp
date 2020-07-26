/*
 * @lc app=leetcode id=1233 lang=cpp
 *
 * [1233] Remove Sub-Folders from the Filesystem
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

#define ALPHABET_SIZE 26
#define CHAR_TO_INT(c) c == '/' ? ALPHABET_SIZE : c - 'a'
#define INT_TO_CHAR(i) i == ALPHABET_SIZE ? '/' : i + 'a'

class Solution {
private:
    struct Trie{
        char this_node_content = 0; //has a value of alphabet or '/'
        int this_node_occurence = 0;
        int num_of_children = 0;
        Trie* children[ALPHABET_SIZE + 1] = {0}; //nodes that represent alphabet and '/'

        Trie* add_node(char c);
        template <class Functor>
        void in_order_traverse(Functor* to_do, string node_content_concat);
    };

public:
    vector<string> removeSubfolders(vector<string>& folder) {
        Trie* trie_root = new Trie();

        //build a Trie tree to store the paths of the folders
        for (int i = 0; i < folder.size(); i++){
            string path = folder[i];
            Trie* trie = trie_root;
            for (int j = 0; j < path.length(); j++)
                trie = trie->add_node(path[j]);
            trie = trie->add_node('/'); //apend '/' to the stored paths
        }

        //in-order traverse through the tree and find out the paths of non-sub folders
        struct Get_result{
            vector<string> result;
            bool _do(Trie* trie, string node_content_concat){
                bool is_end_of_a_path = trie->this_node_occurence > trie->num_of_children;
                if (is_end_of_a_path){
                    //store the result paths with the last '/' chopped off
                    result.push_back(node_content_concat.substr(0, node_content_concat.size() -1)); 
                }
                return !is_end_of_a_path;
            }
        };
        Get_result *get_result = new Get_result();
        trie_root->in_order_traverse(get_result, "");

        return get_result->result;
    }
};

Solution::Trie* Solution::Trie::add_node(char c){
    Trie* new_node = children[CHAR_TO_INT(c)];
    if (new_node){
        new_node->this_node_occurence++;
    }else{
        new_node = new Trie();
        children[CHAR_TO_INT(c)] = new_node;
        new_node->this_node_occurence = 1;
        new_node->this_node_content = c;
    }
    num_of_children++;
    return new_node;
}

template <class Functor>
void Solution::Trie::in_order_traverse(Functor* to_do, string node_content_concat){
    if (this_node_occurence) //when not an empty node, i.e. not the root
        node_content_concat += this_node_content;
    if (to_do->_do(this, node_content_concat)){
        for (int i = 0; i < ALPHABET_SIZE + 1; i++){
            if (children[i])
                children[i]->in_order_traverse(to_do, node_content_concat);
        }
    }
}
// @lc code=end
