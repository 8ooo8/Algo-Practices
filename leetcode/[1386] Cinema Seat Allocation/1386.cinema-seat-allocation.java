/*
 * @lc app=leetcode id=1386 lang=java
 *
 * [1386] Cinema Seat Allocation
 */

// @lc code=start
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats, (s1, s2) -> (s1[0] - s2[0]) * 10 + s1[1] - s2[1]); // Space complexity: O(n) and if it sorts an array of primitive data type, then O(log(n))
        int ans = n * 2, i = 0;
        while (i < reservedSeats.length) {
            int j = i;
            boolean reserved23 = false, reserved45 = false, reserved67 = false, reserved89 = false;
            for (; i < reservedSeats.length && reservedSeats[i][0] == reservedSeats[j][0]; i++) {
                switch (reservedSeats[i][1]) {
                    case 2: case 3:
                        reserved23 = true;
                        break;
                    case 4: case 5:
                        reserved45 = true;
                        break;
                    case 6: case 7:
                        reserved67 = true;
                        break;
                    case 8: case 9:
                        reserved89 = true;
                        break;
                }
            }
            ans -= reserved23 || reserved45 ? 1 : 0;
            ans -= reserved67 || reserved89 ? 1 : 0;
            ans += reserved23 && !reserved45 && !reserved67 && reserved89 ? 1 : 0;
        }
        return ans;
    }
}

/* Below solution would exceeds the memory limit. note that 1 <= n <= 10^9.
 * And, according to a shared solution, approach using `HashMap<Integer, HashSet<Integer>> map` worked. note that 1 <= reservedSeats.length <= min(10*n, 10^4).
 */ 
// boolean[][] seats = new boolean[n + 1][11];
// for (int[] rs : reservedSeats) {
    // seats[rs[0]][rs[1]] = true;
// }

// int ans = 0;
// for (int r = 1; r < seats.length; r++) {
    // int fourAdjSeatsInThisRow = !seats[r][2] && !seats[r][3] && !seats[r][4] && !seats[r][5] ? 1 : 0;
    // fourAdjSeatsInThisRow += !seats[r][6] && !seats[r][7] && !seats[r][8] && !seats[r][9] ? 1 : 0;
    // if (fourAdjSeatsInThisRow == 0)
        // fourAdjSeatsInThisRow = !seats[r][4] && !seats[r][5] && !seats[r][6] && !seats[r][7] ? 1 : 0;
    // ans += fourAdjSeatsInThisRow;
// }

// return ans;

// @lc code=end
