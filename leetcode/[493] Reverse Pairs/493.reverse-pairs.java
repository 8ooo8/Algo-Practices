/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 */

// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {
        if (nums.length <= 1) return 0;

        int result = 0;
        List<Long> sortedNums = new ArrayList<>(nums.length);
        sortedNums.add(new Long(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            int indexOfNewNumDoubleValue = _getIndexForNewNum(sortedNums, new Long(nums[i]) * 2, 0, i - 1);
            result += i - indexOfNewNumDoubleValue;
            int indexOfNewNum = _getIndexForNewNum(sortedNums, nums[i], 0, i - 1);
            sortedNums.add(indexOfNewNum, new Long(nums[i]));
        }
        return result;
    }

    private int _getIndexForNewNum(List<Long> sortedNums, long newNum, int from, int to) {
        if (to - from <= 1) {
            if (sortedNums.get(from) > newNum)
                return from;
            else if (sortedNums.get(to) > newNum)
                return to;
            else
                return to + 1;
        }

        int mid = (to - from) / 2 + from;
        if (sortedNums.get(mid) > newNum)
            return _getIndexForNewNum(sortedNums, newNum, from, mid);
        return _getIndexForNewNum(sortedNums, newNum, mid, to);
    }
}
// @lc code=end
