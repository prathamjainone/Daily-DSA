class Solution {
    int r[]={1,0};
    int c[]={0,1};
    public int uniquePathsWithObstacles(int[][] matrix) {
        if(matrix[0][0]==1)return 0;
        int n=matrix.length;
        int m=matrix[0].length;
        int dp[][]=new int[n][m];
        for(int[]d:dp)Arrays.fill(d,-1);
        return uniquepaths(n,m,matrix,0,0,dp);
    }

    public int uniquepaths(int n,int m,int[][]matrix,int i,int j,int dp[][]){
        if(i==n-1 && j==m-1 && matrix[i][j]!=1)return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        int down=0;
        int right=0;
        for(int k=0;k<2;k++){
            int row=r[k]+i;
            int col=c[k]+j;
            if(valid(row,col,n,m) && matrix[row][col]!=1){
                if(k==0)down=0+uniquepaths(n,m,matrix,row,col,dp);
                else if(k==1)right=0+uniquepaths(n,m,matrix,row,col,dp);
            }
        }
        return dp[i][j]=down+right;
    }

    public boolean valid(int i,int j,int n,int m){
        if(i>=0 && i<n && j>=0 && j<m)return true;
        return false;
    }
}