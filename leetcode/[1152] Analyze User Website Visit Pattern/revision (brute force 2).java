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
    class Visit implements Comparable<Visit>{
        int timestamp;
        String website;
        Visit (int timestamp, String website) {
            this.timestamp = timestamp;
            this.website = website;
        }
        
        public int compareTo(Visit visit) {
            return timestamp - visit.timestamp;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, Queue<Visit>> visits = new HashMap();
        for (int i = 0; i < username.length; i++) {
            visits.putIfAbsent(username[i], new PriorityQueue<>((v1, v2) -> v1.timestamp - v2.timestamp));
            visits.get(username[i]).offer(new Visit(timestamp[i], website[i]));
        }

        Map<String, Integer> scores = new HashMap(); // <pattern, score>
        int maxScore = 0;
        String maxScorePattern = "";
        for (var v : visits.values()) {
            Set<String> foundPatterns = new HashSet(); // use Set to remove duplicate found patterns to ensure no more than 1 score from the same user to a pattern
            // String[] visitedWebsites = v.stream().map(vw -> vw.website).toArray(String[]::new); // note that toArray() doesn't maintain the element order
            String[] visitedWebsites = new String[v.size()];
            for (int i = 0; i < visitedWebsites.length; i++) visitedWebsites[i] = v.poll().website;
            for (int i = 0; i < visitedWebsites.length - 2; i++) {
                for (int j = i + 1; j < visitedWebsites.length - 1; j++) {
                    for (int p = j + 1; p < visitedWebsites.length; p++) {
                        foundPatterns.add(visitedWebsites[i] + " " + visitedWebsites[j] + " " + visitedWebsites[p]); // may user StringBuilder to boost the speed
                    }
                }
            }
            for (String p : foundPatterns) {
                int newScore = scores.getOrDefault(p, 0) + 1;
                scores.put(p, newScore);
                if (newScore > maxScore || (newScore == maxScore && maxScorePattern.compareTo(p) > 0)) {
                    maxScore = newScore;
                    maxScorePattern = p;
                }

            }
        }

        return Arrays.asList(maxScorePattern.split(" "));

    }
}
// @lc code=end
