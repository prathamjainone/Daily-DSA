class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

                for (int i = 0; i < V; i++) {
                    adj.add(new ArrayList<>());
                }

                for (int[] e : edges) {
                    int u = e[0];
                    int v = e[1];

                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }

                // Step 2: Initialize distance array and BFS queue
                int[] dist = new int[V];
                Arrays.fill(dist, -1);

                Queue<Integer> q = new LinkedList<>();

                // Distance from source to itself is 0
                dist[src] = 0;
                q.offer(src);

                // Step 3: Perform BFS
                while (!q.isEmpty()) {

                    int node = q.poll();

                    // If destination is reached, return its distance
                    if (node == dest)
                        return dist[node];
                        for (int neighbor : adj.get(node)) {
                                        if (dist[neighbor] == -1) {
                                            dist[neighbor] = dist[node] + 1;
                                            q.offer(neighbor);
                                        }
                                    }
                                }
                                return -1;
    }
}