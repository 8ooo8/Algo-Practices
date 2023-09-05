/*
 * @lc app=leetcode id=1410 lang=java
 *
 * [1410] HTML Entity Parser
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public String entityParser(String text) {
        Map<String, Character> parser = Map.of(
                "&quot;", '"',
                "&apos;", '\'',
                "&amp;", '&',
                "&gt;", '>',
                "&lt;", '<',
                "&frasl;", '/'
                );
        StringBuilder res = new StringBuilder();
        int i = 0, j;
        while ((j = text.indexOf('&', i)) >= 0) {
            res.append(text.substring(i, j));
            i = j;
            boolean hasSemicolon = false;
            for (j++; j < Math.min(i + 8, text.length()); j++) {
                if (text.charAt(j) == ';') {
                    hasSemicolon = true;
                    break;
                }
            }
            if (hasSemicolon && parser.containsKey(text.substring(i, j + 1))) {
                res.append(parser.get(text.substring(i, j + 1)));
                i = j + 1;
            } else {
                res.append(text.charAt(i++));
            }
        }
        if (i < text.length()) res.append(text.substring(i));
        return res.toString();
    }
}
// @lc code=end
