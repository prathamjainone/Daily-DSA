class Solution {
    int time=1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<connections.size();i++){
            adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        List<List<Integer>>bridge=new ArrayList<>();
        int end[]=new int[n];
        int start[]=new int[n];
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i])dfs(adj,bridge,i,end,start,-1,vis);
        }
        return bridge;
    }
    public void dfs(List<List<Integer>>adj,List<List<Integer>>bridge,int i,int[]end,int[]start,int parent,boolean[]vis){
        vis[i]=true;
        start[i]=time;
        end[i]=time;
        time++;
        for(int it:adj.get(i)){
            if(!vis[it])dfs(adj,bridge,it,end,start,i,vis);
        }
        for(int it:adj.get(i)){
            if(it!=parent)start[i]=Math.min(start[it],start[i]);
        }
        if(parent!=-1 && start[i]>end[parent]){
            List<Integer>temp=new ArrayList<>();
            temp.add(i);
            temp.add(parent);
            bridge.add(temp);
        }
    }
}