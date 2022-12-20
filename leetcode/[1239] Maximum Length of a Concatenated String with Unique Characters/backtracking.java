/*
 * @lc app=leetcode id=1239 lang=java
 *
 * [1239] Maximum Length of a Concatenated String with Unique Characters
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;

class Solution {
    private static int LETTERS_MASK = (1 << 26) - 1;

    public int maxLength(List<String> arr) {
        List<Integer> stringBits = new ArrayList<>();
        for (String s : arr) {
            boolean withDuplicatedLetter = false;
            int bitsForS = 0;
            for (char c : s.toCharArray()) {
                int mask = 1 << c - 'a';
                if ((bitsForS & mask) > 0) {
                    withDuplicatedLetter = true;
                    break;
                }
                bitsForS += mask;
            }
            if (!withDuplicatedLetter)
                stringBits.add(bitsForS + (s.length() << 26)); // store the string length at the same time
        }

        return backtracking(0, stringBits, 0);
    }

    // this actually at the same time is DFS
    private int backtracking(int i, List<Integer> stringBits, int concatString) {
        int best = concatString >>> 26; // the way it can go farthest, if no more string concatenation available

        for (int j = i; j < stringBits.size(); j++) {
            int thisStringBits = stringBits.get(j);
            if ((concatString & thisStringBits & LETTERS_MASK) == 0) {
                // not to create a new int to reduce the consumed space, instead here uses backtracking.
                // the effectiveness will grow if it is not an int but a map of letter occurences
                int add = (thisStringBits & LETTERS_MASK) + (thisStringBits >>> 26 << 26); 
                concatString += add;
                best = Math.max(best, backtracking(j + 1, stringBits, concatString));
                concatString -= add; // backtrack
            }
        }
        
        return best;
    }
}
// @lc code=end
