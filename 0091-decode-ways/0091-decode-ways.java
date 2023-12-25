class Solution {
    
    public int n;
    public String s;
    public int[] dp;
    
    public int dfs(int index) {
        if (index == n) {
            return 1;
        }
        
        if (dp[index] != -1) {
            return dp[index];
        }
        
        dp[index] = 0;
        int now = s.charAt(index) - '0';
        
        if (now == 0) {
            return dp[index];
        }
        
        dp[index] += dfs(index + 1);
        
        if (index + 1 != n) {
            int nownow = now * 10 + (s.charAt(index + 1) - '0');
            
            if (nownow <= 26) {
                dp[index] += dfs(index + 2);
            }
        }
        
        return dp[index];
    }
    
    public int numDecodings(String s) {
        this.n = s.length();
        this.s = s;
        this.dp = new int[n];
        Arrays.fill(dp, -1);
        
        return dfs(0);
    }
}