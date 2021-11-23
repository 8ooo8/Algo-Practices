/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // version 1
        // var minStrLen = Arrays.stream(strs).map(String::length).min(Integer::compare).get(); // note that this is slower
        String s0 = strs[0];
        int minStrLen = s0.length();
        for (int i = 1; i < strs.length; i++) {
            minStrLen = Math.min(minStrLen, strs[i].length());
        }
        for (int i = 0; i < minStrLen; i++) {
            for (int j = 1; j < strs.length; j++)
                if (s0.charAt(i) != strs[j].charAt(i))
                    return s0.substring(0, i);
        }
        return s0.substring(0, minStrLen);

        // version 2
        // String s0 = strs[0];
        // if (strs.length == 1) return s0;
        // int i = 0; 
        // try{
            // for (;;i++) {
                // for (int j = 1; j < strs.length; j++)
                    // if (s0.charAt(i) != strs[j].charAt(i))
                        // return s0.substring(0, i);
            // }
        // } finally {
            // return s0.substring(0, i);
        // }

    }
}
// @lc code=end
