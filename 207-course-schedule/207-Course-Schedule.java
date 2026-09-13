class Solution {
    public boolean canFinish(int N, int[][] arr) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<arr.length;i++){
            adj.get(arr[i][1]).add(arr[i][0]);
        }
        return findCycle(adj);
    }
    public boolean findCycle(ArrayList<ArrayList<Integer>>adj){
        int indegree[]=new int [adj.size()];
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                indegree[adj.get(i).get(j)]++;
            }
        }
        Queue<Integer>q=new ArrayDeque<>();
        for(int i=0;i<adj.size();i++){
            if(indegree[i]==0)q.offer(i);
        }
        int ans=0;
        while(!q.isEmpty()){
            int el=q.poll();
            ans++;
            for(int it:adj.get(el)){
                indegree[it]--;
                if(indegree[it]==0)q.offer(it);
            }
        }
        return ans==adj.size();
    }
}