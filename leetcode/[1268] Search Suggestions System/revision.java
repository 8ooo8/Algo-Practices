/*
 * @lc app=leetcode id=1268 lang=java
 *
 * [1268] Search Suggestions System
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ret = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            ret.add(getSuggestions(products, searchWord.substring(0, i)));
        }
        return ret;
    }

    private List<String> getSuggestions(String[] products, String searchWord) {
        // binary search
        int l = 0, r = products.length - 1, m;
        while (l < r) { // loop till l = r
            m = (l + r) / 2;
            if (searchWord.compareTo(products[m]) <= 0)
                r = m; // = m instead of m + 1 cause m is a possible answer
            else
                l = m + 1; // = m + 1 since (1) m may not be the answer, and (2) avoid the forever loop led by "l = m", where l and m are equal
        }

        List<String> ret = new ArrayList<>();
        for (; l < products.length && ret.size() < 3; l++)
            if (products[l].substring(0, Math.min(products[l].length(), searchWord.length())).equals(searchWord))
                ret.add(products[l]);

        return ret;
    }
}
// @lc code=end
