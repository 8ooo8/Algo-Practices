/*
 * @lc app=leetcode id=1152 lang=java
 *
 * [1152] Analyze User Website Visit Pattern
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, Map<Integer, String>> visits = new HashMap(); // <username, <timestamp, website>>
        for (int i = 0; i < username.length; i++) {
            visits.putIfAbsent(username[i], new TreeMap());
            visits.get(username[i]).put(timestamp[i], website[i]);
        }

        Map<String, Integer> scores = new HashMap(); // <pattern, score>
        int maxScore = 0;
        String maxScorePattern = "";
        for (var v : visits.values()) {
            String[] visitedWebsites = v.values().toArray(String[]::new);
            Set<String> foundPatterns = new HashSet(); // use Set to remove duplicate patterns to avoid more than one score an user may add to a pattern
            for (int i = 0; i < visitedWebsites.length - 2; i++) {
                for (int j = i + 1; j < visitedWebsites.length - 1; j++) {
                    for (int p = j + 1; p < visitedWebsites.length; p++)
                        foundPatterns.add(visitedWebsites[i] + " " + visitedWebsites[j] + " " + visitedWebsites[p]);
                }
            }
            for (String p : foundPatterns) {
                int newScore = scores.getOrDefault(p, 0) + 1;
                scores.put(p, newScore);
                if (newScore > maxScore || (newScore == maxScore && p.compareTo(maxScorePattern) < 0)) {
                    maxScore = newScore;
                    maxScorePattern = p;
                }
            }
        }

        return Arrays.asList(maxScorePattern.split(" "));
    }
}
// @lc code=end
