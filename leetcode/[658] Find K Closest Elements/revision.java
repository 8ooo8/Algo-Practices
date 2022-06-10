/*
 * @lc app=leetcode id=658 lang=java
 *
 * [658] Find K Closest Elements
 */

// @lc code=start
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int from = 0, to = arr.length - k;
        while (to > from) {
            int mid = (to + from) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                from = mid + 1;
            else
                to = mid;
        }
        List<Integer> ans = new ArrayList<Integer>(k);
        for (int i = from; i < from + k; i++)
            ans.add(arr[i]);
        return ans;
    }
}
// @lc code=end
