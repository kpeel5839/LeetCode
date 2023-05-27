class Solution {
    public int n;
    public int[] sum;
    public int[][] dp;
    public int INF = Integer.MAX_VALUE;
    
    public int dfs(int alice, int index) {
        if (n <= index) {
            return 0;
        }
        
        if (dp[alice][index] != INF) {
            return getSum(index, n - 1) - dp[alice][index];
        }
        
        dp[alice][index] = Integer.MIN_VALUE;
        
        for (int i = 1; i <= 3; i++) {
            int v = getSum(index, index + i - 1);
            v += dfs((alice + 1) % 2, index + i);
            dp[alice][index] = Math.max(dp[alice][index], v);
        }
        
        return getSum(index, n - 1) - dp[alice][index];
    }
    
    public int getSum(int start, int end) {
        int startValue = start - 1 < 0 ? 0 : sum[start - 1];
        int endValue = sum[Math.min(n - 1, end)];
        return (sum[n - 1] - startValue) - (sum[n - 1] - endValue);
    }
    
    public String winner(int bobScore) {
        int aliceScore = sum[n - 1] - bobScore;
        
        if (aliceScore < bobScore) {
            return "Bob";
        }
        
        if (aliceScore > bobScore) {
            return "Alice";
        }
        
        return "Tie";
    }
    
    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        sum = new int[n];
        dp = new int[2][n];
        Arrays.fill(dp[0], INF);
        Arrays.fill(dp[1], INF);
        sum[0] = stoneValue[0];
        
        for (int i = 1; i < n; i++) {
            sum[i] = stoneValue[i] + sum[i - 1];
        }
        
        return winner(dfs(0, 0));
    }
}