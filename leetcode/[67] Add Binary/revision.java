/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        int carry = 0, aBit, bBit, sum;
        StringBuilder ans = new StringBuilder();
        for (int aI = a.length() - 1, bI = b.length() - 1; aI >= 0 || bI >= 0 || carry > 0; aI--, bI--) {
            aBit = aI >= 0 && a.charAt(aI) == '1' ? 1 : 0;
            bBit = bI >= 0 && b.charAt(bI) == '1' ? 1 : 0;
            sum = aBit + bBit + carry;
            carry = sum / 2;
            ans.append(sum % 2);
        }
        return ans.reverse().toString();
    }
}
// @lc code=end
