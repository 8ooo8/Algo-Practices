/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> openToEnd = Map.of('(', ')', '[', ']', '{', '}');
        Stack<Character> openBrackets = new Stack<>();
        for (char c : s.toCharArray()) {
            if (openToEnd.containsKey(c))
                openBrackets.push(c);
            else if (openBrackets.empty() || openToEnd.get(openBrackets.pop()) != c)
                return false;
        }
        return openBrackets.empty();
    }
}
// @lc code=end
