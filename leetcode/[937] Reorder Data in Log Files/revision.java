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
    public String[] reorderLogFiles(String[] logs) {
        String[][] chops = new String[logs.length][2];
        for (int i = 0; i < logs.length; i++) {
            String[] splitted = logs[i].split(" ", 2);
            chops[i][0] = splitted[0]; // identifier
            chops[i][1] = splitted[1]; // content
        }

        String[] ret = new String[logs.length];
        int i, j;
        // place digit-logs after letter-logs while keeping their relative order
        for (i = chops.length - 1, j = chops.length - 1; i >= 0; i--) {
            if (Character.isDigit(chops[i][1].charAt(0))) {
                // swap chops[i] with chops[j]
                String identifier = chops[j][0];
                String content = chops[j][1];

                chops[j][0] = chops[i][0];
                chops[j][1] = chops[i][1];

                chops[i][0] = identifier;
                chops[i][1] = content;

                j--;
            }
        }

        // sort the letter-logs
        Arrays.sort(chops, 0, j + 1, (c1, c2) -> {
            int contentComp = c1[1].compareTo(c2[1]);
            return contentComp == 0 ? c1[0].compareTo(c2[0]) : contentComp;
        });

        return Stream.of(chops).map(c -> c[0] + " " + c[1]).toArray(String[]::new);
    }
}
// @lc code=end
