/*
 * @lc app=leetcode id=1647 lang=java
 *
 * [1647] Minimum Deletions to Make Character Frequencies Unique
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);
        // Here it uses sorting but actually we may use a HashSet instead
        // Time complexity comparison: sorting (O(n + K * logK) v.s. HashSet (n + K^2), where K is the maximum possbile number of the distinct characters
        int[] orderedFreq = freq.values().stream().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int ans = 0;
        for (int i = 1; i < orderedFreq.length; i++) {
            if (orderedFreq[i] >= orderedFreq[i - 1]) {
                int del = orderedFreq[i] - orderedFreq[i - 1] + 1;
                del = orderedFreq[i] - del >= 0 ? del : orderedFreq[i];
                orderedFreq[i] -= del;
                ans += del;
            }
        }
        return ans;
    }
}
// @lc code=end
