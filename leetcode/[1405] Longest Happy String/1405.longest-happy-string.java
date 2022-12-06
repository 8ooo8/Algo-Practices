/*
 * @lc app=leetcode id=1405 lang=java
 *
 * [1405] Longest Happy String
 */

// @lc code=start
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder ans = new StringBuilder();
        Queue<Pair<Character, Integer>> q = new PriorityQueue<>(3, (e1, e2) -> e2.getValue() - e1.getValue());
        q.offer(new Pair<>('a', a));
        q.offer(new Pair<>('b', b));
        q.offer(new Pair<>('c', c));
        int numOfConsecutiveLetters = 0;
        char consecutiveLetter = q.peek().getKey();
        while (!q.isEmpty()) {
            Pair<Character, Integer> maxRemainLetters = q.poll();
            if ((numOfConsecutiveLetters < 2 || consecutiveLetter != maxRemainLetters.getKey()) && maxRemainLetters.getValue() > 0) {
                ans.append(maxRemainLetters.getKey());
                numOfConsecutiveLetters = consecutiveLetter == maxRemainLetters.getKey() ? numOfConsecutiveLetters + 1 : 1;
                consecutiveLetter = maxRemainLetters.getKey();
                q.offer(new Pair<>(maxRemainLetters.getKey(), maxRemainLetters.getValue() - 1));
            } else if (!q.isEmpty()){
                // insert another character to break 3 consecutive letters, i.e. 'aaa', 'bbb' and 'ccc'
                Pair<Character, Integer> secondMaxRemainLetters = q.poll();
                if (secondMaxRemainLetters.getValue() > 0) {
                    ans.append(secondMaxRemainLetters.getKey());
                    numOfConsecutiveLetters = 1;
                    consecutiveLetter = secondMaxRemainLetters.getKey();
                    q.offer(new Pair<>(secondMaxRemainLetters.getKey(), secondMaxRemainLetters.getValue() - 1));
                }
                q.offer(new Pair<>(maxRemainLetters.getKey(), maxRemainLetters.getValue()));
            }
        }

        return ans.toString();
    }
}
// @lc code=end
