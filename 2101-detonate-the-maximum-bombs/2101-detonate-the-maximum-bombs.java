class Solution {
    
    public List<ArrayList<Integer>> graph = new ArrayList<>();
    public Set<Integer> visited;
    public int count;
    public int ans = 0;
    
    public void dfs(int v) {
        if (visited.contains(v)) {
            return;
        }
        
        count++;
        ans = Math.max(ans, count);
        visited.add(v);
        
        for (int next : graph.get(v)) {
           dfs(next); 
        } 
    }
    
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());     
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                
                double d = Math.sqrt(Math.pow(bombs[i][0] - bombs[j][0], 2) + Math.pow(bombs[i][1] - bombs[j][1], 2));
                if (d <= bombs[i][2]) {
                    graph.get(i).add(j);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            visited = new HashSet<>();
            count = 0;
            dfs(i);
        }
       
        return ans;
    }
}