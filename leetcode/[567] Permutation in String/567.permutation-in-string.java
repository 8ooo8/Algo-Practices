/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    // note that even it is static, it is also counted into the running time.
    static final int allMatched = (1 << 26) - 1;
    static final int[] bitmaskToRemoveBits = new int[26];
    static final int[] bits = new int[26];
    static {
        for (int i = 0; i < 26; i++) {
            bits[i] = 1 << i;
            bitmaskToRemoveBits[i] = ~0 - bits[i];
        }
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;

        int[] s1CharCount = new int[26], s2CharCount = new int[26];
        int matched = 0;
        final int allMatched = (1 << 26) - 1;

        for (int i = 0; i < s1.length(); i++) {
            s1CharCount[s1.charAt(i) - 'a']++;
            s2CharCount[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            matched |= (s1CharCount[i] == s2CharCount[i] ? 1 : 0) << i;
        }

        if (matched == allMatched)
            return true;
        for (int from = 1, to = s1.length(); to < s2.length(); to++, from++) {
            int abandoned = s2.charAt(from - 1) - 'a', added = s2.charAt(to) - 'a';
            s2CharCount[abandoned]--;
            s2CharCount[added]++;
            matched = matched & bitmaskToRemoveBits[abandoned] & bitmaskToRemoveBits[added];
            if (s1CharCount[abandoned] == s2CharCount[abandoned])
                matched |= bits[abandoned];
            if (s1CharCount[added] == s2CharCount[added])
                matched |= bits[added];
            if (matched == allMatched)
                return true;
        }
        return false;
    }
}
// @lc code=end
