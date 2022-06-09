/*
 * @lc app=leetcode id=1461 lang=java
 *
 * [1461] Check If a String Contains All Binary Codes of Size K
 */

// @lc code=start
class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i + k <= s.length(); i++) set.add(s.substring(i, i + k));
        return set.size() == Math.pow(2, k);
    }
}
// @lc code=end
