class Solution {
    
    public List<int[]> edges = new ArrayList<>();
    public int[] parent;

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }

    public void union(int a, int b) {
        parent[b] = a;
    }

    public void setEdges(int[][] points) {
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                edges.add(new int[] {i, j, getDistance(points[i], points[j])});
            }
        }
    }
    
    public int getDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
    
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        setEdges(points);
        Collections.sort(edges, (o1, o2) -> o1[2] - o2[2]);
        int ans = 0;

        for (int[] edge : edges) {
            int a = find(edge[0]);
            int b = find(edge[1]);
            
            if (a != b) {
                ans += edge[2];
                union(a, b);
            }
        }

        return ans;
    }
}