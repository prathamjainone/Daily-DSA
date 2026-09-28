class Solution {
    public class DSU{
        int parent[];
        int rank[];
        public DSU(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        public int find(int node){
            if(parent[node]==node)return node;
            return parent[node]=find(parent[node]);
        }
        public void union(int u,int v){
            int pu=find(u);
            int pv=find(v);
            if(pu==pv)return;
            if(rank[pu]>rank[pv]){
                parent[pv]=pu;
            }
            else if(rank[pv]>rank[pu]){
                parent[pu]=pv;
            }
            else{
                parent[pv]=pu;
                rank[pu]++;
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        DSU d=new DSU(n);
        if(connections.length<n-1)return -1;
        for(int i=0;i<connections.length;i++){
            d.union(connections[i][0],connections[i][1]);
        }
        int components=0;
        for(int i=0;i<n;i++){
            if(d.find(i)==i)components++;
        }
        if(components==1)return 0;
        return components-1;
    }
}