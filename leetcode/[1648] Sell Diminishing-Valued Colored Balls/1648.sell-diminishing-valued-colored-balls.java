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
        inventory = Arrays.stream(inventory).boxed().sorted(Collections.reverseOrder()).mapToInt(i -> i).toArray();

        int lastOrderProfit = 0, colorsToSell = 0, accumulatedOrders = 0;
        for (;colorsToSell < inventory.length; colorsToSell++) {
            long ordersPossiblyToAdd = ((long)inventory[colorsToSell] - (colorsToSell < inventory.length - 1 ? inventory[colorsToSell + 1] : 0)) * (colorsToSell + 1);
            if (accumulatedOrders + ordersPossiblyToAdd >= orders) {
                lastOrderProfit = inventory[colorsToSell] - (int)Math.ceil((orders - accumulatedOrders) / (colorsToSell + 1.0)) + 1;
                break;
            }
            accumulatedOrders += ordersPossiblyToAdd;
        }
        colorsToSell = Math.min(colorsToSell, inventory.length - 1);

        accumulatedOrders = 0;
        long profit = 0;
        for (int color = 0; color <= colorsToSell; color++) {
            profit = (profit + (long)inventory[color] * (inventory[color] + 1) / 2 - (long)lastOrderProfit * (lastOrderProfit + 1) / 2) % 1000_000_007;
            accumulatedOrders += inventory[color] - lastOrderProfit;
        }
        
        return (int)((profit + (long)(orders - accumulatedOrders) * lastOrderProfit) % 1000_000_007);
    }
}
// @lc code=end
