class Solution {
    public int n;
    public int[][][] dp;
    public int[] sum;
    
    public int getSum(int start, int end) {        
        int totalValue = sum[n - 1];
        int startValue = start - 1 < 0 ? 0 : sum[start - 1];
        int endValue = sum[Math.min(n - 1, end)];    
        int result = (sum[n - 1] - startValue) - (sum[n - 1] - endValue);        
        return result;
    }
    
    public int dfs(int alice, int x, int index) {
        if (n <= index) {
            return 0;
        }
        
        if (dp[alice][x][index] != 0) {
            return getSum(index, n - 1) - dp[alice][x][index];
        }
            
        for (int i = 1; i <= x * 2; i++) {        
            int v = getSum(index, index + i - 1);            
            v += dfs((alice + 1) % 2, Math.max(i, x), index + i);
            dp[alice][x][index] = Math.max(dp[alice][x][index], v);
        }        
        
        return getSum(index, n - 1) - dp[alice][x][index];
    }
    
    public int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new int[2][n * 2][n];
        sum = new int[n];
        sum[0] = piles[0];
        
        for (int i = 1; i < piles.length; i++) {        
            sum[i] = piles[i] + sum[i - 1];
        }
        
        dfs(0, 1, 0);
        return dp[0][1][0];
    }
}