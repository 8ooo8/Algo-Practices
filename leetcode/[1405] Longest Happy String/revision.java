/*
 * @lc app=leetcode id=1405 lang=java
 *
 * [1405] Longest Happy String
 */

// @lc code=start
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder ans = new StringBuilder();

        PriorityQueue<Pair<Character, Integer>> remain = new PriorityQueue<>(3, (r1 ,r2) -> r2.getValue() - r1.getValue());
        remain.offer(new Pair('a', a));
        remain.offer(new Pair('b', b));
        remain.offer(new Pair('c', c));

        while (!remain.isEmpty()) {
            Pair<Character, Integer> r = remain.poll();
            char letter = r.getKey();
            if (ans.length() >= 2 && ans.charAt(ans.length() - 1) == letter && ans.charAt(ans.length() - 2) == letter) {
                Pair<Character, Integer> tmp = r;
                r = remain.poll();
                if (r != null)
                    remain.offer(tmp);
            }
            if (r != null && r.getValue() >= 1) {
                ans.append(r.getKey());
                remain.offer(new Pair(r.getKey(), r.getValue() - 1));
            }
        }

        return ans.toString();
    }
}
// @lc code=end
