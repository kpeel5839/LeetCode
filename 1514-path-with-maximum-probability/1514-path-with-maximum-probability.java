class Solution {
    
    public class Path {
        int a;
        double cost;
        
        public Path(int a, double cost) {
            this.a = a;
            this.cost = cost;
        }
    }
    
    public List<List<Path>> graph = new ArrayList<>();
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new Path(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new Path(edges[i][0], succProb[i]));
        }
        
        double[] visited = new double[n];
        Queue<Path> q = new LinkedList<>();
        q.add(new Path(start, 1d));
        visited[start] = 1d;
        
        while (!q.isEmpty()) {
            Path point = q.poll();
            
            for (Path path : graph.get(point.a)) {
                if (visited[path.a] < point.cost * path.cost) {
                    q.add(new Path(path.a, point.cost * path.cost));
                    visited[path.a] = point.cost * path.cost;
                }
            }
        }
        
        return visited[end];
    }
}