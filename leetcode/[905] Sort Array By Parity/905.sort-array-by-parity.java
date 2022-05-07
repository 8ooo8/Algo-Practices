/*
 * @lc app=leetcode id=905 lang=java
 *
 * [905] Sort Array By Parity
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        IntStream even = IntStream.of(nums).filter(n -> n % 2 == 0);
        IntStream odd = IntStream.of(nums).filter(n -> n % 2 == 1);
        return IntStream.concat(even, odd).toArray();
    }
}
// @lc code=end
