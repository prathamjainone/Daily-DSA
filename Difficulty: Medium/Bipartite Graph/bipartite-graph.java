class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int color[]=new int[V];
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                boolean b=dfs(adj,color,0,i);
                if(!b)return false;
            }
        }
        return true;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>>adj,int []color,int col,int start){
        if(color[start]!=-1){
            if(color[start]==col)return true;
            else return false;
        }
        boolean b=false;
        color[start]=col;
        for(int it:adj.get(start)){
            b=dfs(adj,color,1-col,it);
            if(!b)return false;
        }
        return true;
    }
}