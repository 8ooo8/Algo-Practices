/*
 * @lc app=leetcode id=2272 lang=java
 *
 * [2272] Substring With Largest Variance
 */

// @lc code=start
class Solution {
    public int largestVariance(String s) {
        // return Math.max(helper(s), helper(new StringBuilder(s).reverse().toString()));
        return helper(new StringBuilder(s).reverse().toString());
    }

    private int helper(String s) {
        int[][] maxToMinVariances = new int['z' + 1]['z' + 1];
        Set<Character> occurred = new HashSet<>();
        int ans = 0;
        for (char c : s.toCharArray()) {
            for (int min = 'a'; min <= 'z'; min++) {
                if (occurred.contains((char)min)) {
                    System.out.println("here");
                    maxToMinVariances[c][min]++;
                    ans = Math.max(ans, maxToMinVariances[c][min]);
                }
            }
            for (int max = 'a'; max <= 'z'; max++) {
                maxToMinVariances[max][c] = Math.max(-1, maxToMinVariances[max][c] - 1);
            }
            occurred.add(c);
            System.out.println(occurred);

            System.out.println(c);
        for (int i = 'a'; i <= 'b'; i++) {
            System.out.println(Arrays.toString(Arrays.copyOfRange(maxToMinVariances[i], 'a', 'z' + 1)));
        }
        }
        return ans;
    }
}
// @lc code=end
