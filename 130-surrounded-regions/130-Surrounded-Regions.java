class Solution {
    private int[] delRow = { -1, 0, 1, 0 };
    private int[] delCol = { 0, 1, 0, -1 };

    public void solve(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Visited array
        boolean[][] vis = new boolean[n][m];

        // Traverse boundary rows
        for (int j = 0; j < m; j++) {

            // First row
            if (!vis[0][j] && mat[0][j] == 'O') {
                dfs(0, j, vis, mat, n, m);
            }

            // Last row
            if (!vis[n - 1][j] &&
                    mat[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, mat, n, m);
            }
        }

        // Traverse boundary columns
        for (int i = 0; i < n; i++) {

            // First column
            if (!vis[i][0] && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat, n, m);
            }

            // Last column
            if (!vis[i][m - 1] &&
                    mat[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, mat, n, m);
            }
        }

        // Convert all unvisited 'O's to 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 'O' && !vis[i][j]) {
                    mat[i][j] = 'X';
                }
            }
        }

    }

    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    private void dfs(int row, int col,
            boolean[][] vis,
            char[][] mat,
            int n, int m) {

        // Stack to store cells for DFS
        Stack<int[]> stack = new Stack<>();

        // Mark the starting cell as visited
        vis[row][col] = true;
        stack.push(new int[] { row, col });

        // Continue until all connected cells are processed
        while (!stack.isEmpty()) {

            // Get the top cell
            int[] cell = stack.pop();
            int currRow = cell[0];
            int currCol = cell[1];

            // Check the 4 neighbors
            for (int i = 0; i < 4; i++) {

                // Determine coordinates of the neighboring cell
                int nRow = currRow + delRow[i];
                int nCol = currCol + delCol[i];

                // If the neighbor is valid, contains 'O',
                // and has not been visited
                if (isValid(nRow, nCol, n, m) &&
                        mat[nRow][nCol] == 'O' &&
                        !vis[nRow][nCol]) {

                    // Mark it before adding to the stack
                    vis[nRow][nCol] = true;

                    // Add the neighbor to the stack
                    stack.push(new int[] { nRow, nCol });
                }
            }
        }
    }
}