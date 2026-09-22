class Solution {
    static int timer=1;
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean vis[]=new boolean[V];
        boolean ap[]=new boolean[V];
        int low[]=new int[V];
        int tin[]=new int[V];
        for(int i=0;i<V;i++){
            dfs(i,-1,low,tin,vis,ap,adj);
        }
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(ap[i])ans.add(i);
        }
        if(ans.size()==0)return new ArrayList<>(Arrays.asList(-1));
        return ans;
    }
    static void dfs(int node,int parent,int[]low,int[]tin,boolean[]vis,boolean[]ap,ArrayList<ArrayList<Integer>>adj){
        vis[node]=true;
        low[node]=timer;
        tin[node]=timer;
        timer++;
        int child=0;
        for(int it:adj.get(node)){
            if(it==parent)continue;
            if(!vis[it]){
                dfs(it,node,low,tin,vis,ap,adj);
                child++;
                low[node]=Math.min(low[node],low[it]);
                if(low[it]>=tin[node] && parent!=-1)ap[node]=true;
            }
            else{
                low[node]=Math.min(low[node],tin[it]);
            }
        }
        if(child>1 && parent==-1){
            ap[node]=true;
        }
    }
}