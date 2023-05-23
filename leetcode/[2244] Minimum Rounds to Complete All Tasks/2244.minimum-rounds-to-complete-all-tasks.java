/*
 * @lc app=leetcode id=2244 lang=java
 *
 * [2244] Minimum Rounds to Complete All Tasks
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> difficultyCount = new HashMap<>(); // <difficulty, count>
        for (int d : tasks)
            difficultyCount.put(d, difficultyCount.getOrDefault(d, 0) + 1);

        int rounds = 0;
        for (int c : difficultyCount.values()) {
            if (c <= 1) return -1;
            rounds += c / 3 + (c % 3 == 0 ? 0 : 1);
        }
        return rounds;
    }
}
// @lc code=end
