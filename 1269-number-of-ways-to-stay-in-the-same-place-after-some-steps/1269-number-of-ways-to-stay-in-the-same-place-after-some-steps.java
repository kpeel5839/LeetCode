class Solution {

    public int n;
    public int l;
    public int[][] dp;
    public int MOD = 1_000_000_007;

    public int dfs(int i, int j) {
        if (i == n) {
            if (j == 0) {
                return 1;
            }

            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        dp[i][j] = 0;

        if (j != 0) {
            dp[i][j] = (dp[i][j] + dfs(i + 1, j - 1)) % MOD;
        }

        dp[i][j] = (dp[i][j] + dfs(i + 1, j)) % MOD;

        if (j != l - 1) {
            dp[i][j] = (dp[i][j] + dfs(i + 1, j + 1)) % MOD;
        }

        return dp[i][j];
    }

    public int numWays(int steps, int arrLen) {
        this.n = steps;
        this.l = Math.min((steps / 2) + 1, arrLen);
        dp = new int[n][l];    
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return dfs(0, 0);
    }
}