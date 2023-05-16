/*
 * @lc app=leetcode id=1710 lang=java
 *
 * [1710] Maximum Units on a Truck
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (t1, t2) -> t2[1] - t1[1]);
        int ans = 0, boxesOnTruck = 0;
        for (int i = 0; i < boxTypes.length && boxesOnTruck < truckSize; i++) {
            int boxesToPutOn = Math.min(boxTypes[i][0], truckSize - boxesOnTruck);
            ans += boxesToPutOn * boxTypes[i][1];
            boxesOnTruck += boxesToPutOn;
        }
        return ans;
    }
}
// @lc code=end
