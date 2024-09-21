import java.util.*;
// DFS CODE; MUST ACKNOWLEDGE LATER
public class Island_Water {
    public int numSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    // Find the island in grid2
                    List<int[]> cells = new ArrayList<>();
                    if (dfs(grid2, i, j, visited, cells)) {
                        // Check if this island is a sub-island of grid1
                        if (isSubIsland(grid1, cells)) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid, int x, int y, boolean[][] visited, List<int[]> cells) {
        int m = grid.length, n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y]) {
            return false;
        }

        visited[x][y] = true;
        cells.add(new int[] { x, y });

        // Visit all 4 directions
        dfs(grid, x + 1, y, visited, cells);
        dfs(grid, x - 1, y, visited, cells);
        dfs(grid, x, y + 1, visited, cells);
        dfs(grid, x, y - 1, visited, cells);

        return true;
    }

    private boolean isSubIsland(int[][] grid1, List<int[]> cells) {
        for (int[] cell : cells) {
            int x = cell[0], y = cell[1];
            if (grid1[x][y] != 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Island_Water solution = new Island_Water();
        int[][] grid1 = { { 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1 } };
        int[][] grid2 = { { 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1 }, { 0, 1, 0, 0, 0 }, { 1, 0, 1, 1, 0 },
                { 0, 1, 0, 1, 0 } };
        System.out.println(solution.numSubIslands(grid1, grid2)); // Output: 3
    }
}
