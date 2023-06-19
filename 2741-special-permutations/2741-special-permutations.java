class Solution {
    
    public final int MOD = 1_000_000_007;
    public int[][] dp;
    public int[] nums;
    public int n; 
    
    public int dfs(int bit, int i) {
        if (bit == (1 << n) - 1) {
            return 1;
        }
        
        if (dp[bit][i] != -1) {
            return dp[bit][i];
        }
        
        dp[bit][i] = 0;
        int now = nums[i];
        
        for (int j = 0; j < n; j++) {
            if ((bit & (1 << j)) == 0 && (now % nums[j] == 0 || nums[j] % now == 0)) {
                dp[bit][i] = (dp[bit][i] + dfs(bit | (1 << j), j)) % MOD;
            }
        }
        
        return dp[bit][i] % MOD;
    }
    
    public int specialPerm(int[] nums) {
        n = nums.length;
        this.nums = nums;
        dp = new int[1 << n][n];
        int ans = 0;
        
        for (int i = 0; i < (1 << n); i++) {
            Arrays.fill(dp[i], -1);
        }
        
        for (int i = 0; i < n; i++) {
            ans = (ans + dfs(1 << i, i)) % MOD;
        }
        
        return ans;
    }
}