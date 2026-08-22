class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n=maze.length;
        boolean grid[][]=new boolean[n][n];
        ArrayList<String>ans=new ArrayList<>();
        ArrayList<Character>ch=new ArrayList<>();
        chuha(maze,grid,0,0,ans,ch,n);
        return ans;
    }
    
    public void chuha(int[][]maze,boolean[][]grid,int i,int j,ArrayList<String>ans,ArrayList<Character>ch,int n){
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) return;
        if(i==n || j==n)return;
        if(grid[i][j]==true)return;
        if(i==n-1 && j==n-1){
            StringBuilder sb=new StringBuilder();
            for(int k=0;k<ch.size();k++){
                sb.append(ch.get(k));
            }
            ans.add(sb.toString());
            return;
        }
        grid[i][j]=true;
        
        
        //down
        if(isValid(i+1,j,n) && maze[i+1][j]==1){
            ch.add('D');
            chuha(maze,grid,i+1,j,ans,ch,n);
            ch.remove(ch.size()-1);
        }
        //left
        if(isValid(i,j-1,n) && maze[i][j-1]==1){
            ch.add('L');
            chuha(maze,grid,i,j-1,ans,ch,n);
            ch.remove(ch.size()-1);
        }
        //right
        if(isValid(i,j+1,n) && maze[i][j+1]==1){
            ch.add('R');
            chuha(maze,grid,i,j+1,ans,ch,n);
            ch.remove(ch.size()-1);
        }
        //up
        if(isValid(i-1,j,n) && maze[i-1][j]==1){
            ch.add('U');
            chuha(maze,grid,i-1,j,ans,ch,n);
            ch.remove(ch.size()-1);
        }
        grid[i][j]=false;
    }
    
    public boolean isValid(int i,int j,int n){
        if((i>=0 && j>=0) && (i<n && j<n))return true;
        return false;
    }
}