/*
 * @lc app=leetcode id=1653 lang=java
 *
 * [1653] Minimum Deletions to Make String Balanced
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int minimumDeletions(String s) {
        int sLen = s.length();
        int[] postBs = new int[sLen + 1];
        int[] preAs = new int[sLen];
        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) == 'b')
                preAs[i] = i > 0 ? preAs[i - 1] + 1 : 1;
            else
                preAs[i] = i > 0 ? preAs[i - 1] : 0;
        }
        for (int i = sLen - 1; i >= 0; i--) {
            if (s.charAt(i) == 'a')
                postBs[i] = postBs[i + 1] + 1;
            else
                postBs[i] = postBs[i + 1];
        }
        int ans = postBs[0]; // the case of leaving the string with only 'b' letters
        for (int i = 0; i < sLen; i++) {
            ans = Math.min(ans, preAs[i] + postBs[i + 1]);
        }
        return ans;
    }
}
// @lc code=end
