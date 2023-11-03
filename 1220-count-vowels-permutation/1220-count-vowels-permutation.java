class Solution {
    
    public int n;
    public int[][] graph = new int[][] {{1}, {0, 2}, {0, 1, 3, 4}, {2, 4}, {0}};
    public int[][] dp;
    public final int MOD = 1_000_000_007;

    public int dfs(int now, int index) {
        if (index == n) {
            return 1;
        }
        
        if (dp[now][index] != -1) {
            return dp[now][index];
        }

        dp[now][index] = 0;

        for (int next : graph[now]) {
            dp[now][index] = (dp[now][index] + dfs(next, index + 1)) % MOD;
        }

        return dp[now][index];
    }
    
    public int countVowelPermutation(int n) {
        this.n = n;
        dp = new int[5][n];
        int ans = 0;

        for (int i = 0; i < 5; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        for (int i = 0; i < 5; i++) {
            ans = (ans + dfs(i, 1)) % MOD;
        }

        return ans;
    }
}