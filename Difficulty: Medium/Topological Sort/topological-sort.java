class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        ArrayList<Integer>ans=new ArrayList<>();
        boolean visited[]=new boolean[V];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(visited,st,adj,i);
            }
        }
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
    
    public void dfs(boolean[]visited,Stack<Integer>st,ArrayList<ArrayList<Integer>>adj,int start){
        
        visited[start]=true;
        for(int it:adj.get(start)){
            if(!visited[it]){
                dfs(visited,st,adj,it);
            }
        }
        st.push(start);
    }
}