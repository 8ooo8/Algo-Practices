/*
 * @lc app=leetcode id=1880 lang=java
 *
 * [1880] Check if Word Equals Summation of Two Words
 */

// @lc code=start
import java.util.function.*;
class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        Function<String, Integer> toNum = str -> {
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < str.length(); i++)
                ans.append(str.charAt(i) - 'a');
            return ans.length() == 0 ? 0 : Integer.parseInt(ans.toString());
        };
        return toNum.apply(firstWord) + toNum.apply(secondWord) == toNum.apply(targetWord);
    }
}
// @lc code=end
