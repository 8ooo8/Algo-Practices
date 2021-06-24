/*
 * @lc app=leetcode id=1443 lang=javascript
 *
 * [1443] Minimum Time to Collect All Apples in a Tree
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {boolean[]} hasApple
 * @return {number}
 */
var minTime = function(n, edges, hasApple) {
    edges = edges.reduce((map, [vertexA, vertexB]) => {
        map[vertexA] = map[vertexA] || [];
        map[vertexA].push(vertexB);
        map[vertexB] = map[vertexB] || [];
        map[vertexB].push(vertexA);
        return map;
    }, {});

    let visitCount = 0;
    const visited = Array(n).fill(false);
    const _DFS = (i) => {
        visited[i] = true;
        let needVisit = hasApple[i];
        edges[i]?.forEach(j => needVisit = (!visited[j] && _DFS(j)) || needVisit);
        if (needVisit) visitCount++;
        return needVisit;
    };
    _DFS(0);
    return visitCount ? visitCount * 2 - 2 : 0;
}
// @lc code=end
