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
    class Node {
        Node[] next = new Node[26]; // represent the character by the index
        boolean isEndOfProductName; // as product[i] is unique, no need of int variable to count the occurrences
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node trie = new Node();

        for (String p : products) {
            Node cur = trie;
            for (char c : p.toCharArray()) {
                if (cur.next[c - 'a'] == null)
                    cur.next[c - 'a'] = new Node();
                cur = cur.next[c - 'a'];
            }
            cur.isEndOfProductName = true;
        }

        List<List<String>> ret = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            List<String> suggestions = new ArrayList<>();
            getSuggestions(trie, searchWord.substring(0, i), new StringBuilder(), suggestions);
            ret.add(suggestions);
        }

        return ret;
    }

    // recursion instead of while-loop to leverage the multiple sets of stack data - roll back to previous state to continue the computation becomes easier
    private void getSuggestions(Node trie, String searchWord, StringBuilder suggestion, List<String> suggestions) {
        if (suggestion.length() < searchWord.length()) {
            char c = searchWord.charAt(suggestion.length());
            if (trie.next[c - 'a'] == null)
                return;
            getSuggestions(trie.next[c - 'a'], searchWord, suggestion.append(c), suggestions);
        }
        // actually may separate the below and upper code into 2 functions to make it clearer and less complicated
        else if (suggestions.size() < 3) {
            if (trie.isEndOfProductName)
                suggestions.add(suggestion.toString());
            for (int i = 0; i < trie.next.length; i++) {
                if (trie.next[i] != null) {
                    getSuggestions(trie.next[i], searchWord, suggestion.append((char)(i + 'a')), suggestions);
                    suggestion.deleteCharAt(suggestion.length() - 1);
                }
            }
        }
    }
}
// @lc code=end
