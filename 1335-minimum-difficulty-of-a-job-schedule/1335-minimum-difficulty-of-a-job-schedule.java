class Solution {
    
    public int[][] dp;
    public int d;
    public int[] jd;
    public final int INF = 1_000_000_000;
    
    public int dfs(int index, int duringDay) {
        if (d < duringDay) {
            return INF;
        }
            
        if (index == jd.length) {
            if (duringDay != d) {
                return INF;
            }
            
            return 0;
        }
        
        if (dp[duringDay][index] != INF) {
            return dp[duringDay][index];
        }
        
        int max = 0;
        for (int i = index; i < jd.length; i++) {
            max = Math.max(max, jd[i]);
            dp[duringDay][index] = Math.min(dp[duringDay][index], dfs(i + 1, duringDay + 1) + max);
        }
        
        return dp[duringDay][index];
    }
    
    public int minDifficulty(int[] jobDifficulty, int d) {
        this.jd = jobDifficulty;
        this.d = d;
        
        if (jd.length < d) {
            return -1;
        }
        
        this.dp = new int[d + 1][jd.length];
        
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        return dfs(0, 0);
    }
    
}