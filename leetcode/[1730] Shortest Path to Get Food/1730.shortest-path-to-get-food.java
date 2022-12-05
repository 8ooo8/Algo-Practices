/*
 * @lc app=leetcode id=1730 lang=java
 *
 * [1730] Shortest Path to Get Food
 */

// @lc code=start
class Solution {
    public int getFood(char[][] grid) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int steps = 0;
        Queue<int[]> currentLocations = new ArrayDeque<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '*') {
                    currentLocations.offer(new int[]{r, c});
                    break;
                }
            }
        }

        while (!currentLocations.isEmpty()) {
            steps++;
            int numOfCurrentLocations = currentLocations.size();
            for (int i = 0; i < numOfCurrentLocations; i++) {
                int[] location = currentLocations.poll();
                for (int[] dir : dirs) {
                    int newR = location[0] + dir[0];
                    int newC = location[1] + dir[1];
                    if (newR >= 0 && newC >= 0 && newR < grid.length && newC < grid[0].length && !visited[newR][newC]) {
                        if (grid[newR][newC] == '#')
                            return steps;
                        if (grid[newR][newC] == 'O')
                            currentLocations.offer(new int[]{newR, newC});
                        visited[newR][newC] = true;
                    }
                }
            }
        }

        return -1;
    }
}
// @lc code=end
