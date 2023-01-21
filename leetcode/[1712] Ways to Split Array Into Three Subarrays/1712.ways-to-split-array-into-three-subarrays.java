/*
 * @lc app=leetcode id=1712 lang=java
 *
 * [1712] Ways to Split Array Into Three Subarrays
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int waysToSplit(int[] nums) {
        int N = nums.length;
        int[] prefixSums = new int[N];

         // another possbile approach: add 1 extra element to `prefixSums` to avoid the `i > 0` checking
         // but such an approach may require + 1 to the index every time we access `prefixSums`, which may lead to a mistake
        for (int i = 0; i < N; i++) prefixSums[i] = nums[i] + (i > 0 ? prefixSums[i - 1] : 0);

        int leftI = 0, minMidI = 1, maxMidI = 1, ans = 0;
        for (; leftI < N - 2; leftI++) {
            minMidI = Math.max(leftI + 1, minMidI);
            while(minMidI < N && prefixSums[minMidI] - prefixSums[leftI] < prefixSums[leftI]) {
                ++minMidI;
            }
            if (minMidI >= N - 1) {
                break;
            }

            int sumOfMidAndRight = prefixSums[N-1] - prefixSums[leftI];
            int maxMidSum = sumOfMidAndRight / 2 + prefixSums[leftI];
            while (maxMidI + 1 < N - 1 && prefixSums[maxMidI + 1] <= maxMidSum) {
                ++maxMidI;
            }
            if (maxMidI + 1 < minMidI) {
                break;
            }
            ans += maxMidI - minMidI + 1;
            ans %= 1_000_000_007;
        }
        return ans;
    }
}
// @lc code=end
