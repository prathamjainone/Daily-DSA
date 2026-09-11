class Solution {
    public int orangesRotting(int[][] grid) {
        //im gonna bfs traversal and count minutes
        //at the end agar saare fresh rotten ho gye toh return minutes wrna -1
        //humko na initially saare 2 wale q me dalne honge coz there can be multiple toh jaldi pura basket rotten hojayega

        int time = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotten = false;
            while (size-- > 0) {
                int i = q.peek()[0];
                int j = q.peek()[1];
                q.poll();
                int[] r = { -1, 1, 0, 0 };
                int[] c = { 0, 0, -1, 1 };
                for (int k = 0; k < 4; k++) {
                    if (valid(i + r[k], j + c[k], n, m) && grid[i + r[k]][j + c[k]] == 1) {
                        rotten = true;
                        grid[i + r[k]][j + c[k]] = 2;
                        q.offer(new int[] { i + r[k], j + c[k] });
                    }
                }
            }
            if (!rotten)
                break;
            time++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }

    public boolean valid(int i,int j,int n,int m){
        if(i>=0 && j>=0 && i<n && j<m)return true;
        return false;
    }
}