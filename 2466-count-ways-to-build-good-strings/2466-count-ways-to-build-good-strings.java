class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high + 1];
        dp[high] = 1;
        int MOD = 1_000_000_007;
        long ans = 0;    
        
        for (int i = high - 1; 0 <= i; i--) {
            dp[i] += i + zero <= high ? dp[i + zero] : 0L;
            dp[i] += i + one <= high ? dp[i + one] : 0L;        
            dp[i] %= MOD;
            
            if (i <= high - low) {
                ans = (ans + dp[i]) % MOD;
            }
        }
        
        return (int) (ans % MOD);
    }
}