class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(int s, ArrayList<ArrayList<Integer>> adj,boolean[] visited, boolean[] recStack) {
        visited[s] = true;
        recStack[s] = true;
        for (int it : adj.get(s)) {
            if (!visited[it]) {
                if (dfs(it, adj, visited, recStack))
                    return true;
            }
            else if (recStack[it]) {
                return true;
            }
        }

        recStack[s] = false; 
        return false;
    }
}