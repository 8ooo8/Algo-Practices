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
    class Word {
        int bits;
        int length;

        Word(int bits, int length) {
            this.bits = bits;
            this.length = length;
        }
    }

    public int maxLength(List<String> arr) {
        List<Word> strInBits = new ArrayList<>(arr.size());
        for (String s : arr) {
            int bitsForS = 0;
            boolean withDuplicatedChar = false;
            for (char c : s.toCharArray()) {
                int bitForC = 1 << c - 'a';
                if ((bitsForS & bitForC) > 0) {
                    withDuplicatedChar = true;
                    break;
                }
                bitsForS += bitForC;
            }
            if (!withDuplicatedChar) {
                strInBits.add(new Word(bitsForS, s.length()));
            }
        }

        List<Word> concatStrInBits = new ArrayList<>();
        concatStrInBits.add(new Word(0, 0));
        for (Word str : strInBits) {
            int numOfConcatStrs = concatStrInBits.size();
            for (int i = 0; i < numOfConcatStrs; i++) {
                Word concatStr = concatStrInBits.get(i);
                if ((str.bits & concatStr.bits) == 0) {
                    concatStrInBits.add(new Word(str.bits + concatStr.bits, str.length + concatStr.length));
                }
            }
        }

        return concatStrInBits.stream().mapToInt(concatStr -> concatStr.length).max().orElse(0);
    }
}
// @lc code=end
