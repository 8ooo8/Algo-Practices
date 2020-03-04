/*
 * @lc app=leetcode id=218 lang=cpp
 *
 * [218] The Skyline Problem
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
    typedef vector<int> Vertex; //[x, y]
    typedef pair<Vertex*, Vertex> Vertex_ref;
    typedef vector<int> Building; //[l, r, h]

public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        /*** Time complexity: O(nlogn) ***/
        vector<Vertex> output;

        if (buildings.empty())
            return output;

        // group all vertices of the buildings into a vector
        size_t numOfVertices = buildings.size() * 2;
        Vertex_ref vertices_ref[numOfVertices];
        for (int bi = 0, vi = 0; bi < buildings.size(); bi++, vi+=2){
            //+ve height for the left vertcies, -ve for the right
            vertices_ref[vi] = make_pair(&buildings[bi], Vertex{buildings[bi][0], buildings[bi][2]});
            vertices_ref[vi + 1] = make_pair(&buildings[bi], Vertex{buildings[bi][1], -buildings[bi][2]}); 
        }
        
        // sort the vertices: from left to right
        sort(vertices_ref, vertices_ref + numOfVertices, 
            [](Vertex_ref vr1, Vertex_ref vr2){ return vr1.second[0] < vr2.second[0]; });
        // building order: from high to low
        multiset<Building*, bool(*)(Building*, Building*)> processingBuildings(
            [](Building* b1, Building* b2){ return (*b1)[2] == (*b2)[2] ? b1 > b2 : (*b1)[2] > (*b2)[2]; }
        );
        // process the vertices from left to right
        int outputCandidateX = vertices_ref[0].second[0], outputCandidateY = vertices_ref[0].second[1];
        processingBuildings.insert(&buildings[0]);
        for (int i = 1; i < numOfVertices; i++){
            Vertex_ref vr = vertices_ref[i];
            Vertex *v = vr.first;
            int x = vr.second[0], y = vr.second[1];
            if (y >= 0) //when it is a start of a building, i.e. when a left vertex
                processingBuildings.insert(v);
            else //when it is an end of a building, i.e. when a right vertex
                processingBuildings.erase(v);
            
            //mark skyline vertices
            if (outputCandidateX != x && (output.empty() ? 1 : outputCandidateY != output.back()[1]))
                output.push_back({outputCandidateX, outputCandidateY});
            outputCandidateX = x;
            //get the height of the highest processing building
            outputCandidateY = processingBuildings.empty() ? 0 : (**processingBuildings.cbegin())[2];
        }
        output.push_back({outputCandidateX, outputCandidateY});
            
        return output;
    }
};
// @lc code=end
