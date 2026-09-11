class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid,int i,int j) {
        grid[i][j]='0';
        if(valid(i-1,j,grid.length,grid[0].length) && grid[i-1][j]=='1'){
            dfs(grid,i-1,j);
        }
        if(valid(i,j-1,grid.length,grid[0].length) && grid[i][j-1]=='1'){
            dfs(grid,i,j-1);
        }
        if(valid(i+1,j,grid.length,grid[0].length) && grid[i+1][j]=='1'){
            dfs(grid,i+1,j);
        }
        if(valid(i,j+1,grid.length,grid[0].length) && grid[i][j+1]=='1'){
            dfs(grid,i,j+1);
        }
    }

    public boolean valid(int i,int j,int m,int n){
        if(i>=0 && i<m && j>=0 && j<n)return true;
        return false;
    }
}