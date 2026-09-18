class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });
        pq.offer(new int[]{0,0,0});
        int dist[][]=new int[heights.length][heights[0].length];
        for(int []i:dist){
            Arrays.fill(i,(int)1e9);
        }
        dist[0][0]=0;
        while(!pq.isEmpty()){
            int[]arr=pq.poll();
            int d=arr[0];
            int r=arr[1];
            int c=arr[2];
            int row[]={-1,1,0,0};
            int col[]={0,0,1,-1};
            for(int i=0;i<4;i++){
                int ro=r+row[i];
                int co=c+col[i];
                if(valid(ro,co,heights.length,heights[0].length)){
                    int dis=Math.abs(heights[r][c]-heights[ro][co]);
                    int maxdis=Math.max(d,dis);
                    if(maxdis<dist[ro][co]){
                        dist[ro][co]=maxdis;
                        pq.offer(new int[]{dist[ro][co],ro,co});
                    }
                }
            }
        }
        return dist[heights.length-1][heights[0].length-1];
    }
    public boolean valid(int i,int j,int n,int m){
        if(i<n && i>=0 && j<m && j>=0)return true;
        return false;
    }
}