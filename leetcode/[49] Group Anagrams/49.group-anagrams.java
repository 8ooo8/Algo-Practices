/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
import java.util.Optional;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String s : strs) {
            m.compute(getSorted(s), (sorted, rawList) -> {
                rawList = Optional.ofNullable(rawList).orElse(new ArrayList<>());
                rawList.add(s);
                return rawList;
            });
        }
        return new ArrayList(m.values());
    }

    private String getSorted(String s) {
        char[] cArr = s.toCharArray();
        Arrays.sort(cArr);
        return String.copyValueOf(cArr);
    }
}
// @lc code=end
