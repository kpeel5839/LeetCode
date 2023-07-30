class Solution {
    public int strangePrinter(String s) {
        int n = s.length(); 
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1; 
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j + i <= n; j++) {
                int a = dp[j + 1][j + i - 1] + ((s.charAt(j) == s.charAt(j + 1) || s.charAt(j) == s.charAt(j + i - 1)) ? 0 : 1);
                int b = dp[j][j + i - 2] + ((s.charAt(j + i - 1) == s.charAt(j) || s.charAt(j + i - 1) == s.charAt(j + i - 2)) ? 0 : 1);
                dp[j][j + i - 1] = Math.min(a, b);
                
                for (int c = j; c < j + i - 1; c++) {
                    dp[j][j + i - 1] = Math.min(dp[j][j + i - 1], dp[j][c] + dp[c + 1][j + i - 1]) ;
                }
            }
        }
        
        return dp[0][n - 1];
    }
}