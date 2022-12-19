/*
 * @lc app=leetcode id=1239 lang=java
 *
 * [1239] Maximum Length of a Concatenated String with Unique Characters
 */

// @lc code=start
class Solution {
    int ans = 0;

    public int maxLength(List<String> strs) {
        List<Set> strsInSet = new ArrayList<Set>();
        strs.forEach(str -> {
            Set strInSet = str.chars().mapToObj(c -> (char)c).collect(Collectors.toSet()); 
            if (str.length() == strInSet.size())
                strsInSet.add(strInSet);
        });
        dfs(strsInSet, new HashSet<Character>(), 0);
        return ans;
    }

    private void dfs(List<Set> strs, Set concatStr, int idx) { // `visited` is not necessary in DFS 
        for (int i = idx; i < strs.size(); i++) {
            if (hasOverlappedLetters(concatStr, strs.get(i)))
                continue;

            Set newConcatStr = new HashSet<Character>(concatStr);
            newConcatStr.addAll(strs.get(i));
            ans = Math.max(ans, newConcatStr.size());
            dfs(strs, newConcatStr, i + 1);
        }
    }

    private boolean hasOverlappedLetters(Set s1, Set s2) {
        return s1.stream().anyMatch(s1Letter -> s2.contains(s1Letter));
    }
}
// @lc code=end
