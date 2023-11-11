class Graph {
    
    public int n;
    public List<List<int[]>> graph = new ArrayList<>();

    public Graph(int n, int[][] edges) {
        this.n = n;
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new int[] {edges[i][1], edges[i][2]});
        }
    }
    
    public void addEdge(int[] edge) {
        graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        int[] dist = new int[n];
        int INF = 1_000_000_000;
        Arrays.fill(dist, INF);
        dist[node1] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        q.add(new int[] {node1, 0});
        
        while (!q.isEmpty()) {
            int[] p = q.poll();
            
            if (dist[p[0]] < p[1]) {
                continue;
            }
            
            if (p[0] == node2) {
                return p[1];
            }
            
            for (int[] next : graph.get(p[0])) {
                if (p[1] + next[1] < dist[next[0]]) {
                    dist[next[0]] = p[1] + next[1];
                    q.add(new int[] {next[0], dist[next[0]]});
                }
            }
        }
        
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */