class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        boolean visited[]=new boolean[adj.size()];
        
        for(int i=0;i<adj.size();i++){
            if(!visited[i]){
                dfss(visited,ans,adj,i);
            }
        }
        return ans;
    }
    
    public void dfss(boolean visited[],ArrayList<Integer>ans,ArrayList<ArrayList<Integer>>adj,int i){
        visited[i]=true;
        ans.add(i);
        for(int j=0;j<adj.get(i).size();j++){
            if(!visited[adj.get(i).get(j)]){
                dfss(visited,ans,adj,adj.get(i).get(j));
            }
        }
    }
}