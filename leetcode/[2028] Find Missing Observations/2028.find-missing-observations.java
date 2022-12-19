/*
 * @lc app=leetcode id=2028 lang=java
 *
 * [2028] Find Missing Observations
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;

        int sumOfKnownRolls = IntStream.of(rolls).sum();
        int sumOfRest = mean * (m + n) - n - sumOfKnownRolls; // the unknown rolls have at least value 1

        int[] result = new int[n];
        System.out.println(sumOfRest);
        if (sumOfRest < 0 || sumOfRest / (double) n > 5) {
            return new int[]{};
        }

        for (int i = 0; i < n; i++)
            result[i] = 1; // the unknown rolls have at least value 1

        for (int i = 5, j = 0; i > 0; i--) {
            int numOfIsToAdd = sumOfRest / i;
            for (int k = 0; k < numOfIsToAdd; k++) {
                result[j + k] += i;
            }
            j += numOfIsToAdd;
            sumOfRest -= numOfIsToAdd * i;
        }

        return result;
    }
}
// @lc code=end
