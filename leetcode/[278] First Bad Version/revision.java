/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long left = 1, right = n;
        while (right > left) {
            long mid = (right + left) / 2;
            if (!isBadVersion((int)mid))
                left = mid + 1;
            else
                right = mid;
        }
        return (int)left;
    }
}
// @lc code=end
