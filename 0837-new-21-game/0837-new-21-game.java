class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) {
            return 1d;
        }
        
        if (n >= k - 1 + maxPts) {
            return 1d;
        }
        
        double w = 1d;
        double ans = 0;
        double[] dp = new double[n + 1];
        dp[0] = 1d;
        
        for (int i = 1; i <= n; i++) {
            dp[i] = w / maxPts;
            
            if (i < k) {
                w += dp[i];
            } else {
                ans += dp[i];
            }
            
            if (maxPts <= i) {
                w = w - dp[i - maxPts];
            }
        }
        
        return ans;
    }
}