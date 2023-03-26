class Solution {
    int[] g;
    int[] id;
    int idValue = 0;
    boolean[] scc;
    Stack<Integer> s = new Stack<>();
    int ans = -1;
    
    public int dfs(int v) {
        id[v] = idValue++;
        int min = id[v];
        s.add(v);
        
        if (g[v] != -1 && id[g[v]] == -1) {
            min = Math.min(min, dfs(g[v]));
        } else if (g[v] != -1 && !scc[g[v]]) {
            min = Math.min(min, id[g[v]]);
        }
        
        if (min == id[v]) {        
            int count = 0;
            
            while (true) {
                int vv = s.pop();
                scc[vv] = true;
                count++;
                
                if (id[vv] == id[v]) {
                    break;
                }
            }
            
            if (count != 1) {
                ans = Math.max(ans, count);   
            }            
        }
        
        return min;
    }
    
    public int longestCycle(int[] edges) {
        g = edges;
        id = new int[g.length];
        scc = new boolean[g.length];
        Arrays.fill(id, -1);
        
        for (int i = 0; i < id.length; i++) {
            if (id[i] == -1) {
                dfs(i);
            }
        }
        
        return ans;
    }
}