/*
 * @lc app=leetcode id=1648 lang=java
 *
 * [1648] Sell Diminishing-Valued Colored Balls
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int maxProfit(int[] inventory, int orders) {
        final long NOT_SELLING = Arrays.stream(inventory).mapToLong(i -> i).sum() - orders;
        final int N = inventory.length;

        Arrays.sort(inventory);
        int i = 0, colorCnt = N, lastOrderProfit;
        long orderCnt = 0, profit;
        for (;;) {
            orderCnt += (long)(inventory[i] - (i > 0 ? inventory[i - 1] : 0)) * colorCnt;
            if (orderCnt >= NOT_SELLING)
                break;
            ++i; --colorCnt; // not putting it into the for-loop condition to maintain the correctness of the values of i and colorCnt
        }
        lastOrderProfit = -(int)Math.floor((orderCnt - NOT_SELLING) / colorCnt) + inventory[i];

        for (profit = 0, orderCnt = 0; i < N; i++, colorCnt--) {
            orderCnt += inventory[i] - lastOrderProfit;
            profit = (profit + (long)inventory[i] * (inventory[i] + 1) / 2 - (long)lastOrderProfit * (lastOrderProfit + 1) / 2) % 1000_000_007;
        }

        return (int)((profit + (orders - orderCnt) * lastOrderProfit) % 1000_000_007);
    }
}
// @lc code=end
