#
# @lc app=leetcode id=91 lang=python3
#
# [91] Decode Ways
#

# @lc code=start
class Solution:
    def numDecodings(self, s: str) -> int:
        if len(s) == 0:
            return 0;

        s = s[::-1]
        dp = [1, 0 if s[0] == '0' else 1]
        for i in range(1, len(s)):
            newDpValue = 0 if s[i] == '0' else dp[i]
            newDpValue += 0 if s[i] == '0' or int(s[i-1 : i+1][::-1]) == 0 or int(s[i-1 : i+1][::-1]) > 26 else dp[i - 1]
            dp.append(newDpValue)

        return dp[-1]
            
# @lc code=end
