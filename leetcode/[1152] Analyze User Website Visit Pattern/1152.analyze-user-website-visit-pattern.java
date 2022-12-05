/*
 * @lc app=leetcode id=1152 lang=java
 *
 * [1152] Analyze User Website Visit Pattern
 */

// @lc code=start
class Solution {
    class Visit {
        String website;
        int timestamp;
        Visit(String website, int timestamp) {
            this.website = website;
            this.timestamp = timestamp;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Visit>> graph = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            graph.putIfAbsent(username[i], new ArrayList<>());
            graph.get(username[i]).add(new Visit(website[i], timestamp[i]));
        }
        graph.forEach((user, visits) -> visits.sort((v1, v2) -> v1.timestamp - v2.timestamp));

        Map<String, Integer> scores = new HashMap<>();
        graph.forEach((user, visits) -> {
            Set<String> countedPatterns = new HashSet<>();
            for (int i = 0; i < visits.size() - 2; i++) {
                for (int j = i + 1; j < visits.size() - 1; j++) {
                    for (int p = j + 1; p < visits.size(); p++) {
                        String pattern = visits.get(i).website + "-" + visits.get(j).website + "-" + visits.get(p).website;
                        if (!countedPatterns.contains(pattern)) {
                            scores.putIfAbsent(pattern, 0);
                            scores.compute(pattern, (k, v) -> v + 1);
                            countedPatterns.add(pattern);
                        }
                    }
                }
            }
        });
        int highestScore = 0;
        String ans = "";
        for (Map.Entry s : scores.entrySet()) {
            int v = (Integer)s.getValue();
            String k = (String)s.getKey();
            if (highestScore == v && ans.compareTo(k) > 0) {
                ans = k;
            } else if (v > highestScore) {
                highestScore = v;
                ans = k;
            }
        }
        return Arrays.asList(ans.split("-"));
    }
}
// @lc code=end
// Lt     ["zkiikgv","zkiikgv","zkiikgv","zkiikgv"]\n[436363475,710406388,386655081,797150921]\n["wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"]
