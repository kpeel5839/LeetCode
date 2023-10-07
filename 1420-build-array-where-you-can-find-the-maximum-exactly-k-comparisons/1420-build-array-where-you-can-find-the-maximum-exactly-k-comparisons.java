class Solution {

    public int n;
    public int m;
    public int k;
    public int MOD = 1_000_000_007;
    public int[][][] dp;

    public int dfs(int index, int nowK, int max) {
        if (k < nowK) {
            return 0;
        }

        if (index == n) {
            if (nowK == k) {
                return 1;
            }

            return 0;
        }

        if (dp[index][nowK][max] != -1) {
            return dp[index][nowK][max];
        }

        dp[index][nowK][max] = 0;
        
        for (int i = 1; i <= m; i++) {
            dp[index][nowK][max] = (dp[index][nowK][max] + dfs(index + 1, max < i ? nowK + 1 : nowK, Math.max(max, i)))% MOD;
        }

        return dp[index][nowK][max] % MOD;
    }

    public int numOfArrays(int n, int m, int k) {
        this.n = n;
        this.m = m;
        this.k = k;
        
        dp = new int[n][k + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k + 1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return dfs(0, 0, 0);
    }
}