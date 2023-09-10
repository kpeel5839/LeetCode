class Solution {
    
    public long MOD = 1_000_000_007;
   
    public long combination(int n) {
        return  (n * (n - 1)) / 2;
    }
    
    public int countOrders(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1L;
        
        for (int i = 2; i <= n; i++) {
            int space = i * 2 - 1;
           
            dp[i] = (dp[i - 1] * (combination(space) + space)) % MOD;
        }
        
        return (int) (dp[n] % MOD);
    }
    
}