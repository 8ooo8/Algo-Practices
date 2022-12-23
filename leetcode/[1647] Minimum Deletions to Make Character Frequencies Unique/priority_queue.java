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

        PriorityQueue<Integer> freqMaxHeap = new PriorityQueue<>(freq.size(), Collections.reverseOrder());
        for (int f : freq.values()) freqMaxHeap.offer(f);

        int maxFreq = freqMaxHeap.poll();
        int ans = 0;
        while (freqMaxHeap.size() > 0) {
            int nextMaxFreq = freqMaxHeap.poll();
            if (maxFreq == nextMaxFreq) {
                ans++;
                if (nextMaxFreq > 1)
                    freqMaxHeap.offer(nextMaxFreq - 1);
            } else {
                maxFreq = nextMaxFreq; // when confirmed no more freq as same as `maxFreq`
            }
        }
        return ans;
    }
}
// @lc code=end
