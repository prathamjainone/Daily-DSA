class DisjointSet {
    /* To store the ranks, parents and 
    sizes of different set of vertices */
    int[] rank, parent, size;

    // Constructor
    DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Function to find ultimate parent
    int findUPar(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findUPar(parent[node]);
    }

    // Function to implement union by size
    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v)
            return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

class Solution {
    int max = 0;
    int row[] = { -1, 1, 0, 0 };
    int col[] = { 0, 0, -1, 1 };

    public int largestIsland(int[][] grid) {
        DisjointSet ds = new DisjointSet(grid.length*grid.length);
        int n = grid.length;
        //union by size krenge initial me jis se component size ajaye
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    initial(ds, grid, n, i, j);
            }
        }
        //ab 0 wala game

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer>set=new HashSet<>();
                    int s=0;
                    for (int k = 0; k < 4; k++) {
                        int r = i + row[k];
                        int c = j + col[k];
                        if (valid(r, c, n) && grid[r][c] == 1) {
                            int node = r * n + c;
                            if(!set.contains(ds.findUPar(node))){
                                s+=ds.size[ds.findUPar(node)];
                                set.add(ds.findUPar(node));
                            }
                        }
                    }
                    max=Math.max(max,s+1);
                }
            }
        }
        int s=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int node=i*n+j;
                    s=Math.max(s,ds.size[ds.findUPar(node)]);
                }
            }
        }
        max=Math.max(max,s);
        return max;
    }

    public boolean valid(int i, int j, int n) {
        if (i >= 0 && i < n && j >= 0 && j < n)
            return true;
        return false;
    }

    public void initial(DisjointSet ds, int[][] grid, int n, int i, int j) {
        for (int k = 0; k < 4; k++) {
            int r = i + row[k];
            int c = j + col[k];
            if (valid(r, c, n) && grid[r][c] == 1) {
                int node = i * n + j;
                int node2 = r * n + c;
                ds.unionBySize(node, node2);
            }
        }
    }
}