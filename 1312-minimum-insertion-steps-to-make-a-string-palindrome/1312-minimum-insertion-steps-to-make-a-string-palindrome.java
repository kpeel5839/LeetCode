class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j + i - 1 < n; j++) {
                int min = Math.min(dp[j][j + i - 2], dp[j + 1][j + i - 1]) + 1;
                
                if (s.charAt(j) == s.charAt(j + i - 1)) {
                    min = Math.min(min, dp[j + 1][j + i - 2]);
                }
                
                dp[j][j + i - 1] = min;
            }
        }
        
        return dp[0][n - 1];
    }
}