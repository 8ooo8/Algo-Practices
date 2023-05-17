/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    class Log {
        String logs;
        int index;
        Log(String logs, int index) {
            this.logs = logs;
            this.index = index;
        }
    }
    public String[] reorderLogFiles(String[] logs) {
        Log[] ret = new Log[logs.length];
        for (int i = 0; i < logs.length; i++) {
            ret[i] = new Log(logs[i], i);
        }

        Arrays.sort(ret, (l1, l2) -> {
            boolean l1IsDigit = Character.isDigit(l1.logs.charAt(l1.logs.indexOf(" ") + 1));
            boolean l2IsDigit = Character.isDigit(l2.logs.charAt(l2.logs.indexOf(" ") + 1));
            if (l1IsDigit && !l2IsDigit) return 1;
            if (l2IsDigit && !l1IsDigit) return -1;
            if (l1IsDigit && l2IsDigit) return l1.index - l2.index;
            // when l1 & l2 both letter-logs
            String[] l1Hunks = l1.logs.split(" ", 2);
            String[] l2Hunks = l2.logs.split(" ", 2);
            int contentComp = l1Hunks[1].compareTo(l2Hunks[1]);
            return contentComp == 0 ? l1Hunks[0].compareTo(l2Hunks[0]) : contentComp;
        });

        return Stream.of(ret).map(l -> l.logs).toArray(String[]::new);
    }
}
// @lc code=end
