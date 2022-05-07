/*
 * @lc app=leetcode id=1202 lang=java
 *
 * [1202] Smallest String With Swaps
 */

// @lc code=start
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        StringBuilder ans = new StringBuilder(s.length());
        int[] disjointSet = IntStream.range(0, s.length()).toArray();
        pairs.forEach(p -> union(disjointSet, p.get(0), p.get(1)));
        Map<Integer, Queue<Character>> m = new HashMap<>();
        for (int i = 0; i < disjointSet.length; i++)
            m.computeIfAbsent(findRoot(disjointSet, i), k -> new PriorityQueue<Character>()).offer(s.charAt(i));
        for (int i = 0; i < s.length(); i++)
            ans.append(m.get(disjointSet[i]).poll());
        return ans.toString();
    }

    private int findRoot(int[] set, int child) {
        if (set[child] == child)
            return child;
        return (set[child] = findRoot(set, set[child])); // path compression
    }

    private void union(int[] set, int x, int y) {
        int xRoot = findRoot(set, x);
        int yRoot = findRoot(set, y);
        if (xRoot != yRoot) // if not forming a cycle
            set[xRoot] = yRoot;
    }
    // TLE: DFS approach
    // private String solution;
    // public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // solution = s;
        // DFS(s, pairs, new HashSet<String>());
        // return solution;
    // }

    // private void DFS(String s, List<List<Integer>> pairs, HashSet<String> visited) {
        // for (int i = 0; i < pairs.size(); i++) {
            // int l = pairs.get(i).get(0), r = pairs.get(i).get(1);
            // char lc = s.charAt(l), rc = s.charAt(r);
            // StringBuilder newStrBuilder = new StringBuilder(s);
            // newStrBuilder.setCharAt(l, rc);
            // newStrBuilder.setCharAt(r, lc);
            // String newStr = newStrBuilder.toString();
            // if (!visited.contains(newStr)) {
                // visited.add(newStr);
                // if (solution.compareTo(newStr) > 0) {
                    // solution = newStr;
                // }
                // DFS(newStr, pairs, visited);
            // }
        // }
    // }
}
// @lc code=end
// "vbjjxgdfnru"\n[[8,6],[3,4],[5,2],[5,5],[3,5],[7,10],[6,0],[10,0],[7,1],[4,8],[6,2]]
