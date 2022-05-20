/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 */

// @lc code=start
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1)
            return -1;
        if (grid.length == 1 && grid[0].length == 1)
            return 1;
        Queue<List<Integer>> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        BiConsumer<Integer, Integer> goToGrid = (row, col) -> { if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0 && !visited[row][col]) {
                q.offer(Arrays.asList(row, col));
                visited[row][col] = true;
            }
        };
        BiConsumer<Integer, Integer> goFromGrid = (row, col) -> {
            goToGrid.accept(row - 1, col - 1);
            goToGrid.accept(row - 1, col);
            goToGrid.accept(row - 1, col + 1);
            goToGrid.accept(row, col + 1);
            goToGrid.accept(row + 1, col + 1);
            goToGrid.accept(row + 1, col);
            goToGrid.accept(row + 1, col - 1);
            goToGrid.accept(row, col - 1);
        };
        int ans = 2;
        visited[0][0] = true;
        goFromGrid.accept(0, 0);
        while (!q.isEmpty()) {
            if (visited[grid.length - 1][grid[0].length - 1])
                return ans;
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                List<Integer> from = q.poll();
                goFromGrid.accept(from.get(0), from.get(1));
            }
            ans++;
        }
        return visited[grid.length - 1][grid[0].length - 1] ? ans : -1;

    }
}
// @lc code=end
