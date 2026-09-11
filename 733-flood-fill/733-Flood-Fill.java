class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        if(image[sr][sc]==color)return image;
        bfs(image, sr, sc, n, m, color);
        return image;
    }

    public void bfs(int[][] image, int r, int c, int n, int m, int color) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c});
        int og=image[r][c];
        while (!q.isEmpty()) {
            int i=q.peek()[0];
            int j=q.peek()[1];
            q.poll();
            
            if (valid(i - 1, j, n, m) && image[i - 1][j] == og) {
                q.add(new int[]{i-1,j});
            }
            if (valid(i + 1, j, n, m) && image[i + 1][j] == og) {
                q.add(new int[]{i+1,j});
            }
            if (valid(i, j - 1, n, m) && image[i][j - 1] == og) {
                q.add(new int[]{i,j-1});
            }
            if (valid(i, j + 1, n, m) && image[i][j + 1] == og) {
                q.add(new int[]{i,j+1});
            }
            image[i][j]=color;
        }
    }

    public boolean valid(int i, int j, int n, int m) {
        if (i >= 0 && i < n && j >= 0 && j < m)
            return true;
        return false;
    }
}