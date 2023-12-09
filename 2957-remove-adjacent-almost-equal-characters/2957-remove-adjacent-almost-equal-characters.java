class Solution {
    
    public int n;
    public int[] w;
    public int[][] dp;
    public int INF = 1_000_000_000;
    
    public int dfs(int pre, int index) {
        if (index == n) {
            return 0;
        }
        
        if (dp[pre][index] != INF) {
            return dp[pre][index];
        }
        
        for (int i = 0; i < 26; i++) {
            if (pre == i || Math.abs(i - w[index]) <= 1) {
                continue;
            }
            
            dp[pre][index] = Math.min(dp[pre][index], dfs(i, index + 1) + 1);
        }
        
        if (1 < Math.abs(pre - w[index])) {
            dp[pre][index] = Math.min(dp[pre][index], dfs(w[index], index + 1));
        }
        
        return dp[pre][index];
    }
        
    public int removeAlmostEqualCharacters(String word) {
        n = word.length();
        w = new int[n];
        dp = new int[26][n];

        for (int i = 0; i < word.length(); i++) {
            w[i] = word.charAt(i) - 'a';
        }
        
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        return dfs(w[0], 1);
    }
}