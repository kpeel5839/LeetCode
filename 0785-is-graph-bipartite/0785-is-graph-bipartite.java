class Solution {
    public int[][] g;
    public int[] cc;
    
    public int convert(boolean b) {
        return b ? 1 : 2;
    }
    
    public boolean dfs(int c, boolean group) {
        cc[c] = convert(group);
        
        for (int next : g[c]) {
            if (cc[next] == convert(group)) {
                return false;            
            }
            
            if (cc[next] == 0) {
                if (!dfs(next, !group)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        g = graph;
        cc = new int[graph.length];

        for (int i = 0; i < g.length; i++) {
            if (cc[i] == 0) {
                if (!dfs(i, true)) {
                    return false;   
                }
            }
        }

        return true;
    }
}