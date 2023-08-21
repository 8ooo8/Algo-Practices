/*
 * @lc app=leetcode id=2101 lang=java
 *
 * [2101] Detonate the Maximum Bombs
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    // This approach runs slow (~210 ms)
    class DetonationChain {
        Set<Integer> knownDetonations = new HashSet<>();
        Set<Integer> linkedTo = new HashSet<>();
    }
    DetonationChain[] dcs; // memo

    public int maximumDetonation(int[][] bombs) {
        int B = bombs.length, ans = 0;
        dcs = new DetonationChain[B];
         // checked that the object creation doesn't take much time, even when their HashSet attributes were initialized with large capacities
        for (int i = 0; i < B; i++)
            dcs[i] = new DetonationChain();

        boolean[] detonated = new boolean[B];
        for (int i = 0; i < B; i++)
            dfs(bombs, detonated, i);
        
        return Arrays.stream(dcs).mapToInt(dc -> dc.knownDetonations.size()).max().getAsInt();
    }

    protected DetonationChain dfs(int[][] bombs, boolean[] detonated, int i) {
        DetonationChain dc = dcs[i];

        // base case
        if (!dc.knownDetonations.isEmpty()) {
            concatChainsFromLinks(dc);
            return dc;
        }

        // recursion
        dc.knownDetonations.add(i); // add itself
        detonated[i] = true;
        for (int j = 0; j < bombs.length; j++) {
            if (i == j) continue;
            int iX = bombs[i][0], iY = bombs[i][1], iR = bombs[i][2];
            int jX = bombs[j][0], jY = bombs[j][1];
            double distance = Math.pow(Math.pow(iX - jX, 2) + Math.pow(iY - jY, 2), 0.5);
            if (distance <= iR) {
                if (detonated[j]) {
                    dc.linkedTo.add(j); // unable to know the detonation chain invoked by `bombs[j]` right now, save `j` into `linkedTo` first
                } else {
                    DetonationChain dcJ = dfs(bombs, detonated, j);
                    dc.knownDetonations.addAll(dcJ.knownDetonations);
                    dc.linkedTo.addAll(dcJ.linkedTo);
                    if (dcJ.linkedTo.contains(i))
                        dc.linkedTo.remove(i); // remove the linkage to itself
                }
            }
        }
        detonated[i] = false;
        return dc;
    }

    protected Set<Integer> concatChainsFromLinks(DetonationChain dc) {
        for (Integer lt : dc.linkedTo)
            dc.knownDetonations.addAll(concatChainsFromLinks(dcs[lt]));
        dc.linkedTo.clear(); // tried `dc.linkedTo = new HashSet<>()` and the resulting time was similar
        return dc.knownDetonations;
    }
}
// @lc code=end
