/*
 * @lc app=leetcode id=453 lang=java
 *
 * [453] Minimum Moves to Equal Array Elements
 */

// @lc code=start
class Solution {
    public int minMoves(int[] nums) {
        /* Algo: in every single step, the number not added 1 actually gains a relative loss of 1, comparing to other numbers.
         *       think it in above way, and reduce all the numbers larger than the smallest number to be equal to the smallest number.
         */
        int minNum = IntStream.of(nums).min().getAsInt();
        return IntStream.of(nums).map(n -> n - minNum).sum();
    }
}
// @lc code=end
