/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (p2 < 0)
                break;
            nums1[i] = p1 >= 0 && nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
    }
}
// @lc code=end
