/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */

// @lc code=start
/*** [vim-leetcode] For Local Syntax Checking ***/
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
import java.lang.*;

class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        for (int i = 1; i < ratings.length; i++)
            candies[i] = ratings[i] > ratings[i - 1] ? candies[i - 1] + 1 : 0;
        for (int i = ratings.length - 2; i >= 0; i--)
            candies[i] = Math.max(candies[i], ratings[i] > ratings[i + 1] ? candies[i + 1] + 1 : 0);
        return Arrays.stream(candies).sum() + candies.length;
    }
}
// @lc code=end
