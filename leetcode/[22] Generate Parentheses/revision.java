/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    private void generateParenthesis(StringBuilder s, List<String> generated, int toOpen, int toEnd) {
        if (toOpen + toEnd == 0) generated.add(s.toString());

        if (toOpen > 0) {
            generateParenthesis(s.append('('), generated, toOpen - 1, toEnd + 1);
            s.deleteCharAt(s.length() - 1);
        }
        if (toEnd > 0) {
            generateParenthesis(s.append(')'), generated, toOpen, toEnd - 1);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(new StringBuilder(), res, n, 0);
        return res;
    }
}
// @lc code=end
