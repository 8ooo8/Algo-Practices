/*
 * @lc app=leetcode id=1578 lang=java
 *
 * [1578] Minimum Time to Make Rope Colorful
 */

// @lc code=start
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int i = 0;
        while (i < colors.length()) {
            char nowColor = colors.charAt(i);
            int maxTime = 0;
            for (; i < colors.length() && colors.charAt(i) == nowColor; i++) { // note that i++ here will in the end move i to the next set of colors / the end of string
                ans += neededTime[i];
                maxTime = Math.max(maxTime, neededTime[i]);
            }
            ans -= maxTime; // the trick to simplify the code
        }
        return ans;
    }
}
// @lc code=end
