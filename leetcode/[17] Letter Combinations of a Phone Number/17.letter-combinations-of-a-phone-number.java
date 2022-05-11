/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    // May use String array to boost the running speed
    Map<Character, List<Character>> mappings = Map.ofEntries(
                Map.entry('2', Arrays.asList('a', 'b', 'c')),
                Map.entry('3', Arrays.asList('d', 'e', 'f')),
                Map.entry('4', Arrays.asList('g', 'h', 'i')),
                Map.entry('5', Arrays.asList('j', 'k', 'l')),
                Map.entry('6', Arrays.asList('m', 'n', 'o')),
                Map.entry('7', Arrays.asList('p', 'q', 'r', 's')),
                Map.entry('8', Arrays.asList('t', 'u', 'v')),
                Map.entry('9', Arrays.asList('w', 'x', 'y', 'z'))
            );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        combine("", digits, result);
        return digits.length() == 0 ? Collections.emptyList() : result;
    }
    
    // May use StringBuilder to boost the running speed
    private void combine(String formedText, String remainDigits, List<String> result) {
        if (remainDigits.length() == 0) {
            result.add(formedText);
        } else {
            for (char c : mappings.get(remainDigits.charAt(0)))
                combine(formedText + c, remainDigits.substring(1), result);
        }
    }
}
// @lc code=end
