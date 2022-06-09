/*
 * @lc app=leetcode id=318 lang=java
 *
 * [318] Maximum Product of Word Lengths
 */

// @lc code=start
class Solution {
    private static int[] bits = new int[26];
    static {
        for (int i = 0; i < bits.length; i++)
            bits[i] = 1 << i;
    }
    public int maxProduct(String[] words) {
        int[] charOccurences = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray())
                charOccurences[i] |= bits[c - 'a'];
        }
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++)
                if ((charOccurences[i] & charOccurences[j]) == 0) ans = Math.max(ans, words[i].length() * words[j].length());
        }
        return ans;
    }
}
// @lc code=end
