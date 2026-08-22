class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>ans=new ArrayList<>();
        List<String>board=new ArrayList<>();
        for(int i=0;i<n;i++){ 
            board.add(".".repeat(n));
        }

        placeNQueens(0,ans,board);
        return ans;
    }

    public void placeNQueens(int row,List<List<String>>ans,List<String>board){
        if(row==board.size()){
            ans.add(new ArrayList<>(board));
            return;
        }

        for(int col=0;col<board.get(0).length();col++){
            if(isSafe(board,row,col)){
                char[]rowArr=board.get(row).toCharArray();
                rowArr[col]='Q';
                board.set(row,new String(rowArr));
                placeNQueens(row+1,ans,board);
                rowArr[col]='.';
                board.set(row,new String(rowArr));
            }
        }
    }

    public boolean isSafe(List<String>board,int row,int col){
        int r=row;
        int c=col;

        //upperleft diagonal
        while(r>=0 && c>=0){
            
            if(board.get(r).charAt(c)=='Q')return false;
            r--;
            c--;
            
        }

        r=row;
        c=col;

        //top
        while(r>=0){
            
            if (board.get(r).charAt(c) == 'Q') return false;
            r--;
        }

        r=row;
        c=col;

        //upper right
        while(r>=0&&c<board.get(0).length()){
            
            if(board.get(r).charAt(c)=='Q')return false;
            r--;
            c++;
        }
        return true;
    }
}