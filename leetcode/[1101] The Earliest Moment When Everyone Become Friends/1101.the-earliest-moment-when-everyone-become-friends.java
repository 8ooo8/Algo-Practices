/*
 * @lc app=leetcode id=1101 lang=java
 *
 * [1101] The Earliest Moment When Everyone Become Friends
 */

// @lc code=start
class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (l1, l2) -> l1[0] - l2[0]);
        int[][] sets = new int[n][2];
        for (int i = 0; i < sets.length; i++) {
            sets[i][0] = i;
            sets[i][1] = 1; // sets[i][1] = the number of set elements
        }
        for (int i = 0; i < logs.length; i++) {
            if (unionAndReturnSetSize(sets, logs[i][1], logs[i][2]) == n)
                return logs[i][0];
        }
        return -1;
    }

    private int findRoot(int[][] sets, int target) {
        if (sets[target][0] == target)
            return target;
        return sets[target][0] = findRoot(sets, sets[target][0]); // path compression
    }

    private int unionAndReturnSetSize(int[][] sets, int a, int b) {
        int rootA = findRoot(sets, a);
        int rootB = findRoot(sets, b);
        if (rootA != rootB) {
            sets[rootB][0] = rootA;
            sets[rootA][1] += sets[rootB][1];
        }
        return sets[rootA][1];
    }
}
// @lc code=end
