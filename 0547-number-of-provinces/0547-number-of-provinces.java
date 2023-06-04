class Solution {

    public List<ArrayList<Integer>> g = new ArrayList<>();
    public boolean[] visited;

    public void dfs(int c) {
        if (visited[c]) {
            return;
        }
        
        visited[c] = true;
        
        for (Integer next : g.get(c)) {
            dfs(next);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || isConnected[i][j] == 0) { 
                    continue;
                }
                
                g.get(i).add(j);
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                ans++;
            }
        }
        
        return ans; 
    }
}