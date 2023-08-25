class Solution {
    
    public String s1;
    public String s2;
    public String s3;
    public int[][][] dp;
    
    public int dfs(int i, int j, int c) {
        if (j == s1.length() && c == s2.length()) {
            return 1;
        }
        
        if (dp[i][j][c] != -1) {
            return dp[i][j][c];
        }
        
        dp[i][j][c] = 0;
        
        if (i == 0) { // j 를 선택할 떄 (jj)
            for (int jj = j; jj < s1.length(); jj++) {
                if (s1.charAt(jj) == s3.charAt(c + jj)) {
                    dp[i][j][c] |= dfs(1, jj + 1, c);
                } else {
                    break;
                }
            }
        } else { // c 를 선택할 떄 (cc)
            for (int cc = c; cc < s2.length(); cc++) {
                if (s2.charAt(cc) == s3.charAt(j + cc)) {
                    dp[i][j][c] |= dfs(0, j, cc + 1);
                } else {
                    break;
                }
            }
        }
        
        return dp[i][j][c];
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        dp = new int[2][s1.length() + 1][s2.length() + 1];
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < s1.length() + 1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        if (dfs(0, 0, 0) == 1 || dfs(1, 0, 0) == 1) {
            return true;
        }
        
        return false;
    }
}