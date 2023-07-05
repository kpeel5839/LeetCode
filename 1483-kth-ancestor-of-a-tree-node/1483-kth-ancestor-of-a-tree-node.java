class TreeAncestor {

    public int[][] p;
    public int[] depth;
    public int height;
    public List<List<Integer>> graph = new ArrayList<>();

    public TreeAncestor(int n, int[] parent) {
        depth = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < parent.length; i++) {
            graph.get(parent[i]).add(i);
        } 
        
        height = (int) Math.ceil(Math.log(n - 1) / Math.log(2)) + 1;

        p = new int[height][n];
        dfs(0, 0);
        
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = p[i - 1][p[i - 1][j]];
            }
        }
    }

    public void dfs(int c, int d) {
        depth[c] = d;
        
        for (Integer next : graph.get(c)) {
            p[0][next] = c;
            dfs(next, d + 1);
        }
    }
    
    public int getKthAncestor(int node, int k) {
        if (depth[node] < k) {
            return -1;
        } 
        
        int jump = 0;

        while (k != 0) {
            if (k % 2 == 1) {
                node = p[jump][node];
            }

            k /= 2; 
            jump++;
        }
        
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */