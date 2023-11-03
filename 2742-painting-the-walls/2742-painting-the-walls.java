class Solution {

    public int n;
    public int[] cost;
    public int[] time;
    public final int INF = 1_000_000_000;
    public int[][] dp;

    public int dfs(int t, int i) {
        if (i == n) {
            if (t < 0) {
                return INF;
            }
            
            return 0;
        }

        if (dp[t + 500][i] != -1) {
            return dp[t + 500][i];
        }

        dp[t + 500][i] = Math.min(dfs(Math.min(n, t + time[i]), i + 1) + cost[i], dfs(t - 1, i + 1));
        return dp[t + 500][i];
    }
    public int paintWalls(int[] cost, int[] time) {
        this.n = cost.length;
        this.time = time;
        this.cost = cost;
        dp = new int[1001][n];
        
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return dfs(0, 0);
    }
}