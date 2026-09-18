class Solution {
	public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
		// code here
		ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
		for (int i = 0; i<V; i++) {
			adj.add(new ArrayList<>());
		}
		for (int i = 0; i<edges.length; i++) {
			adj.get(edges[i][0]).add(new int[] {edges[i][1], edges[i][2]});
			adj.get(edges[i][1]).add(new int[] {edges[i][0], edges[i][2]});
		}
		
		int[]dist = new int[V];
		Arrays.fill(dist, (int)1e9);
		PriorityQueue<int[]>pq = new PriorityQueue<>((a, b)-> {
			if (a[1] != b[1])return a[1]-b[1];
			return a[0]-b[0];
		});
		dist[src] = 0;
		pq.add(new int[] {src, 0});
		
		while (!pq.isEmpty()) {
			int[]arr = pq.poll();
			int d = arr[1];
			int u = arr[0];
			if(d>dist[u])continue;
			for (int i = 0; i<adj.get(u).size(); i++) {
				int v = adj.get(u).get(i)[0];
				int w = adj.get(u).get(i)[1];
				if (w + d<dist[v]) {
					dist[v] = w + d;
					pq.add(new int[] {v, w + d});
				}
			}
		}
		ArrayList<Integer>ans = new ArrayList<>();
		for (int i:dist) {
			ans.add(i);
		}
		return ans;
	}
}
