class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int colors[]=new int[v];
        return c(adj,colors,0,v,m);
    }
    
    public boolean c(ArrayList<ArrayList<Integer>>adj,int[]colors,int i,int n,int m){
        if(i==n)return true;
        
        for(int j=1;j<=m;j++){
            if(isSafe(adj,colors,j,i)){
                colors[i]=j;
                boolean p=c(adj,colors,i+1,n,m);
                if(p==true)return true;
                colors[i]=0;
            }
        }
        return false;
    }
    
    public boolean isSafe(ArrayList<ArrayList<Integer>>adj,int[]colors,int j,int i){
        for(int k=0;k<adj.get(i).size();k++){
            if(colors[adj.get(i).get(k)]==j)return false;
        }
        return true;
    }
}