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

class Solution {
private:
     //sort [l, r] and remove a path when it is found to be a subfolder
    void mergesort(string paths[], int l, int r);
     //merge [l, m] with [m+1, r] and remove a path when it is found to be a subfolder
    void merge(string paths[], int l, int m, int r);

    void printvector(vector<string> vec){
        cout << endl;
        for (int i = 0; i < vec.size(); i++){
            cout << vec[i] << ", ";
        }
        cout << endl;
    }

public:
    vector<string> removeSubfolders(vector<string>& paths) {
        vector<string> result;

        printvector(paths);
        mergesort(&paths[0], 0, paths.size() - 1);
        printvector(paths);

        result.push_back(paths[0]);
        string pre = paths[0];
        for(int i = 1; i< paths.size();i++){
            int j = 0;
            if (pre.length() == 0) {
                pre = paths[i];
                continue;
            }
            if (paths[i].length() == 0)
                continue;
            
            if(pre.size() < paths[i].size()) {
               
                while(j<pre.size() ){
                    if(pre[j]==paths[i][j])
                        j++;
                    else
                        break;
                }
            }
            
            if(pre.size() >= paths[i].size() || j!=pre.size() ||  paths[i][j] !='/'){
                result.push_back(paths[i]);
                pre = paths[i];
                
            }
        }
        return result;
    }
};

void Solution::mergesort(string paths[], int l, int r){
    if (l < r) { 
        // Same as (l+r)/2, but avoids overflow for large l and r
        int m = l + (r - l) / 2; 
  
        Solution::mergesort(paths, l, m); 
        Solution::mergesort(paths, m + 1, r); 
  
        Solution::merge(paths, l, m, r); 
    } 
}

void Solution::merge(string paths[], int l, int m, int r){
    int i, j, k; 
    int n1 = m - l + 1; 
    int n2 = r - m; 
  
    // create temp arrays 
    string L[n1], R[n2]; 
  
    // Copy data to temp arrays L[] and R[] 
    for (i = 0; i < n1; i++) 
        L[i] = paths[l + i];
    for (j = 0; j < n2; j++) 
        R[j] = paths[m + 1 + j]; 
  
    // Merge the temp arrays back into arr[l..r]
    i = 0; // Initial index of first subarray 
    j = 0; // Initial index of second subarray 
    k = l; // Initial index of merged subarray 
    while (i < n1 && j < n2) { 
        // cout << "-----" << endl;
        while (i < n1 && L[i].empty()) {i++;}
        while (j < n2 && R[j].empty()) {j++;}
        if (i >= n1 || j >= n2) break;
        // cout << "##### " <<" l: " << l << ", m: " << m << ", r: " << r << endl;
        // cout << "@@@@@ " << i << ", j: " << j << endl;
        string L_str = L[i] + '/', R_str = R[j] + '/';
        int L_str_size = L_str.length(), R_str_size = R_str.length();
        // cout << "````` " << L_str << ", r_str: " << R_str << endl;
        bool no_subfolder = false;
                // cout << L_str << ", r: " << R_str << ", k: " << k << endl;
        for (int m = 0; m < L_str_size && m < R_str_size; m++){
            if (L_str[m] != R_str[m]){
                if (L_str[m] < R_str[m]){
                    paths[k] = L[i]; 
                    i++;
                }else if (L_str[m] > R_str[m]){
                    paths[k] = R[j]; 
                    j++; 
                }
                // cout << "not: " << "l: " << l << ", r: " << r << ", i: " <<i << ", j: "  << j << ", k: " << k << ", paths[k]: " << paths[k] << endl;
                no_subfolder = true;
                break;
            }
        }
        //Remove subfolder paths
        if (!no_subfolder){
            string parent_folder = L_str_size < R_str_size ? L[i] : R[j];
            // if (L_str_size == 0) cout << " -- L size == 0 -- ";
            // else if (R_str_size == 0) cout << " -- R size == 0 -- ";
            // cout << " -- sizes L/R: " << L_str_size << " / " << R_str_size << " -- ";
            paths[k] = parent_folder;
            paths[k + 1] = "";
            k++;
            i++;
            j++;
                // cout << "sub: " << "l: " << l << ", r: " << r << ", i: " <<i << ", j: "  << j << ", k: " << k << ", paths[k]: " << paths[k - 1] << endl;
        }
        k++; 
    } 
  
    // Copy the remaining elements of L[], if there are any
    while (i < n1) { 
        paths[k] = L[i]; 
        i++; 
        k++; 
    } 
  
    // Copy the remaining elements of R[], if there are any
    while (j < n2) { 
        paths[k] = R[j]; 
        j++; 
        k++; 
    } 
    
    while (k <= r){
        paths[k] = "";
        k++;
    }
}
// @lc code=end
