class Solution {
    public int uniquePaths(int m, int n) {
        long[][] dp = new long[m][n];
        int MOD = 2 * 1_000_000_000;
        
        for (int i = 0; i < Math.max(m, n); i++) {
            dp[Math.min(m - 1, i)][0] = 1;
            dp[0][Math.min(n - 1, i)] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }
        
        return (int) (dp[m - 1][n - 1] % MOD);
    }
}