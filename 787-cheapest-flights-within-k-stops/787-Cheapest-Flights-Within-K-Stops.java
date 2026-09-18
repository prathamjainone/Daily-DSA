class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        } 
        Queue<int[]>pq=new LinkedList<>();
        pq.offer(new int[]{0,src,0});
        int dist[]=new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src]=0;
        while(!pq.isEmpty()){
            int arr[]=pq.poll();
            int kk=arr[2];
            int d=arr[0];
            int u=arr[1];
            if(kk>k)continue;
            for(int i=0;i<adj.get(u).size();i++){
                int v=adj.get(u).get(i)[0];
                int dis=adj.get(u).get(i)[1];
                if(dis+d<dist[v] && kk>=0){
                    dist[v]=dis+d;
                    pq.offer(new int[]{dis+d,v,kk+1});
                }
            }
        }
        return dist[dst]==(int)1e9?-1:dist[dst];
    }
}