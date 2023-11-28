class Solution {
    
    public int n;
    public int[] c;
    public int[][] dp;
    public final int MOD = 1_000_000_007;
    
    public int dfs(int seatCount, int index) {
        if (index == n) {
            if (seatCount == 2) {
                return 1;
            }
            
            return 0;
        }

        seatCount += c[index];
        
        if (3 <= seatCount) {
            return 0;
        }
        
        if (dp[seatCount][index] != -1) {
            return dp[seatCount][index];
        }
        
        dp[seatCount][index] = 0;
        if (seatCount == 2) {
            dp[seatCount][index] = (dp[seatCount][index] + dfs(0, index + 1)) % MOD;
        }
        dp[seatCount][index] = (dp[seatCount][index] + dfs(seatCount, index + 1)) % MOD;
        
        return dp[seatCount][index];
    }
    
    public int numberOfWays(String corridor) {
        this.n = corridor.length();
        this.c = new int[n];
        this.dp = new int[3][n];
        
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        Arrays.fill(dp[2], -1);
        
        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                c[i]++;
            }
        }
        
        return dfs(0, 0);
    }
}