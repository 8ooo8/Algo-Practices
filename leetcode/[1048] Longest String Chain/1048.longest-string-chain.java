/*
 * @lc app=leetcode id=1048 lang=java
 *
 * [1048] Longest String Chain
 */

// @lc code=start
class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> longestChains = new HashMap<>();
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
        for (String w : words) {
            int chain = 1;
            for (int i = 0; i < w.length(); i++) {
                String parent = w.substring(0, i) + w.substring(i + 1, w.length());
                if (longestChains.containsKey(parent))
                    chain = Math.max(longestChains.get(parent) + 1, chain);
            }
            longestChains.put(w, chain);
        }
        return longestChains.values().stream().max(Comparator.naturalOrder()).get();
    }
}
// @lc code=end
