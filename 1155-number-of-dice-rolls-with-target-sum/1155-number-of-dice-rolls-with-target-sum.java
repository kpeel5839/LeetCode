class Solution {
    
    public int n;
    public int k;
    public int target;
    public int[][] dp;
    public final int MOD = 1_000_000_007;
    
    public int dfs(int index, int value) {
        if (target < value) {
            return 0;
        }
        
        if (index == n) {
            if (target == value) {
                return 1;
            }
            
            return 0;
        }
        
        if (dp[value][index] != -1) {
            return dp[value][index];
        }
        
        dp[value][index] = 0;
        
        for (int i = 1; i <= k; i++) {
            dp[value][index] = (dp[value][index] + dfs(index + 1, value + i)) % MOD;
        }
        
        return dp[value][index];
    }
    
    public int numRollsToTarget(int n, int k, int target) {
        this.n = n;
        this.k = k;
        this.target = target;
        dp = new int[target + 1][n];
        
        for (int i = 0; i <= target; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return dfs(0, 0);
    }
}