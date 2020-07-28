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
    //Unlike Trie.cpp, here, a boolean member, namely "is_end_of_a_path", is used
    //to indicate if a node represents the end of a folder path. This shortens the runtime a bit
    //at the expense of the sufficient attributes in Trie objects to identify the "uniqueness" of the input data,
    //i.e. time complexity reduced but so does the extensibility
    //since a potential (environmental) change may require the Trie objects more knowledge about the input data.
    struct Trie{
        char this_node_content = 0; //has a value of alphabet or '/'
        Trie* children[ALPHABET_SIZE + 1] = {0}; //nodes that represent alphabet and '/'
        bool is_end_of_a_path = false;

        Trie* add_node(char c);
        template <class Functor>
        void in_order_traverse(Functor* to_do, string node_content_concat);
    };

    //light-weight linked list (STL list resulted in a longer runtime)
    struct Node{
        string* path;
        Trie* leaf;
        Node* next;

        Node* push_back(string *path, Trie* leaf); //return the new node's pointer
        Node* erase_next_node(); //return the new next node's pointer
    }; 
    
public:
    vector<string> removeSubfolders(vector<string>& paths) {
        Trie* trie_root = new Trie();

        //build a Trie tree to store the paths of the folders.
        //to reduce the time wasted on reading the whole paths of the subfolders,
        //process the folder paths in a horizontal manner,
        //i.e. read the first char of all the paths first, then second char, ...,
        //and once a folder is found to be a subfolder, stop processing it.
        Node list_head; //create a linked list for the horizontal processing
        Node *curr_node = &list_head;
        for (int i = 0; i < paths.size(); i++){
            curr_node = curr_node->push_back(&paths[i], trie_root);
        }
        //in a horizontal manner process the folder paths
        int n_th_char = 0;
        int num_of_paths = paths.size();
        int num_of_remain_paths = num_of_paths;
        while (num_of_remain_paths){
            Node *prev_node = &list_head;
            curr_node = list_head.next;
            int to_process = num_of_remain_paths;
            for (int processed = 0; processed < to_process; processed++){
                Trie* leaf = curr_node->leaf;
                if (leaf->is_end_of_a_path){
                    curr_node = prev_node->erase_next_node();
                    num_of_remain_paths--;
                    continue;
                }

                string path = *(curr_node->path);
                char c = path[n_th_char];
                Trie* new_leaf = leaf->add_node(c);
                if (n_th_char >= path.length() - 1){
                    new_leaf = new_leaf->add_node('/');
                    new_leaf->is_end_of_a_path = true;
                    curr_node->leaf = new_leaf;
                }
                curr_node->leaf = new_leaf;
                prev_node = curr_node;
                curr_node = curr_node->next;
            }
            n_th_char++;
        }

        // struct Test{
        //     bool _do(Trie* trie, string node_content_concat){
        //         cout << node_content_concat << endl;
        //         return true;
        //     }
        // };
        // Test* test = new Test();
        // trie_root->in_order_traverse(test, "");

        //in-order traverse through the tree and find out the paths of non-sub folders
        struct Get_result{
            vector<string> result;
            bool _do(Trie* trie, string node_content_concat){
                if (trie->is_end_of_a_path){
                    //store the result paths with the last '/' chopped off
                    result.push_back(node_content_concat.substr(0, node_content_concat.size() -1)); 
                }
                return !trie->is_end_of_a_path;
            }
        };
        Get_result *get_result = new Get_result();
        trie_root->in_order_traverse(get_result, "");

        return get_result->result;
    }
};

Solution::Trie* Solution::Trie::add_node(char c){
    Trie* new_node = children[CHAR_TO_INT(c)];
    if (!new_node){
        new_node = new Trie();
        children[CHAR_TO_INT(c)] = new_node;
        new_node->this_node_content = c;
    }
    return new_node;
}

template <class Functor>
void Solution::Trie::in_order_traverse(Functor* to_do, string node_content_concat){
    if (this_node_content) //when not an empty node, i.e. not the root
        node_content_concat += this_node_content;
    if (to_do->_do(this, node_content_concat)){
        for (int i = 0; i < ALPHABET_SIZE + 1; i++){
            if (children[i])
                children[i]->in_order_traverse(to_do, node_content_concat);
        }
    }
}

Solution::Node* Solution::Node::push_back(string *path, Trie* leaf){
    next = new Node();
    next->path = path;
    next->leaf = leaf;
    return next;
}

Solution::Node* Solution::Node::erase_next_node(){
    next = next->next;
    // delete next;
    return next;
}
// @lc code=end

