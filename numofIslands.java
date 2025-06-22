class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numRows = grid.length;
        int numCols = grid[0].length;
        int numIslands = 0;

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                if (grid[r][c] == '1') {
                    numIslands++;
                    dfs(grid, r, c);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int r, int c) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        if (r < 0 || r >= numRows || c < 0 || c >= numCols || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';

        dfs(grid, r + 1, c); 
        dfs(grid, r - 1, c); 
        dfs(grid, r, c + 1); 
        dfs(grid, r, c - 1); 
    }
}
