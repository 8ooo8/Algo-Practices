/*
 * @lc app=leetcode id=473 lang=java
 *
 * [473] Matchsticks to Square
 */

// @lc code=start
class Solution {
    public boolean makesquare(int[] matchsticks) {
        double sideLength = IntStream.of(matchsticks).sum() / 4;
        matchsticks = IntStream.of(matchsticks).boxed().sorted(Collections.reverseOrder()).mapToInt(v -> v.intValue()).toArray(); // reduce running time
        return sideLength == (int)sideLength ? DFS(new int[4], matchsticks, 0, (int)sideLength) : false;
    }

    public boolean DFS(int[] sides, int[] matchsticks, int stick, int sideLength) {
        if (stick >= matchsticks.length) return true;
        for (int i = 0; i < 4; i++) {
            sides[i] += matchsticks[stick];
            if (sides[i] <= sideLength && DFS(sides, matchsticks, stick + 1, sideLength))
                return true;
            sides[i] -= matchsticks[stick];
        }
        return false;
    }
}
// @lc code=end
