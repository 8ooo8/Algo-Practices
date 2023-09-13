/*
 * @lc app=leetcode id=1268 lang=java
 *
 * [1268] Search Suggestions //System
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    private int search(String[] products, String searchWord, int from, int to) {
        if (to - from <= 1) {
            if (products[from].substring(0, Math.min(searchWord.length(), products[from].length())).equals(searchWord))
                return from;
            if (products[to].substring(0, Math.min(searchWord.length(), products[to].length())).equals(searchWord))
                return to;
            return -1;
        }

        int mid = (from + to) / 2;
        int cmp = searchWord.compareTo(products[mid]);
        if (cmp <= 0)
            return search(products, searchWord, from, mid);
        return search(products, searchWord, mid, to);
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 0; i < searchWord.length(); i++) {
            res.add(new ArrayList<>());
            String curSearchWord = searchWord.substring(0, i + 1);
            for (int j = 0, searchRes = -1; j < 3 && searchRes < products.length - 1; j++) {
                searchRes = search(products, curSearchWord, searchRes + 1, products.length - 1);
                if (searchRes < 0)
                    break;
                res.get(res.size() - 1).add(products[searchRes]);
            }
        }
        return res;
    }
}
// @lc code=end
