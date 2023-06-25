class Solution {
    
    public int[] l;
    public int s;
    public int f;
    public int[][] dp;
    public final int MOD = 1_000_000_007;
    
    public int dfs(int index, int fuel) {
        if (fuel < 0) {
            return 0;
        }
        
        if (dp[index][fuel] != -1) {
            return dp[index][fuel];
        }
        
        dp[index][fuel] = index == f ? 1 : 0;
        
        for (int i = 0; i < l.length; i++) {
            if (index != i) {
                dp[index][fuel] = (dp[index][fuel] + dfs(i, fuel - Math.abs(l[index] - l[i]))) % MOD;
            }
        }
        
        return dp[index][fuel];
    }
        
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        l = locations;
        s = start;
        f = finish;
        dp = new int[locations.length][fuel + 1];
        
        for (int i = 0; i < locations.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return dfs(start, fuel);
    }
}