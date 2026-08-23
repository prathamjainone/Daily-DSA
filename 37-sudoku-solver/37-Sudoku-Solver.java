class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][]board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char digit='1';digit<='9';digit++){
                        if(isSafe(digit,i,j,board)){
                            board[i][j]=digit;
                            boolean k=solve(board);
                            if(k==true)return true;
                            board[i][j]='.';
                        }
                        }
                        return false;
                }
            }
        }
        return true;
    }

    public boolean isSafe(char digit,int i,int j,char[][]board){
        for(int k=0;k<9;k++){
            if(board[i][k]==digit)return false;
            if(board[k][j]==digit)return false;
        }
        int boxrow=0;
        int boxcol=0;
        if(i<3)boxrow=0;
        else if(i<6)boxrow=3;
        else if(i<9)boxrow=6;
        if(j<3)boxcol=0;
        else if(j<6)boxcol=3;
        else if(j<9)boxcol=6;
        int limit=boxrow+3;
        while(boxrow<limit){
            for(int k=boxcol;k<boxcol+3;k++){
                if(board[boxrow][k]==digit)return false;
            }
            boxrow++;
        }
        return true;
    }
}