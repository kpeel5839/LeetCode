class Solution {

    public int n;
    public int[][] graph;
    public int[][] dp;
    public List<List<int[]>> shortest = new ArrayList<>(); 
    public int INF = 1_000_000_000;
    
    public void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(new int[] {start, 0});
        visited[start] = true;
        List<int[]> addList = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int next : graph[p[0]]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[] {next, p[1] + 1});
                    addList.add(new int[] {next, p[1] + 1});
                }
            }
        }
        
        shortest.add(addList);
    }

    public int dfs(int index, int bit) {
        if (bit == ((1 << n) - 1))  {
            return 0;
        }
        
        if (dp[index][bit] != INF) {
            return dp[index][bit];
        }
        
        for (int[] next : shortest.get(index)) {
            if ((bit & (1 << next[0])) == 0) {
                dp[index][bit] = Math.min(dp[index][bit], dfs(next[0], bit | (1 << next[0])) + next[1]);
            }
        }

        return dp[index][bit];
    }

    public int shortestPathLength(int[][] graph) {
        this.n = graph.length;
        this.graph = graph;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            bfs(i);
        }
        
        // 자 이제 이렇게 구했으면 bit masking 으로 dp 를 진행해주면됨
        dp = new int[n][1 << n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dfs(i, 1 << i));
        }
        
        return ans;
    }

}