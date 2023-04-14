class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        
        for (int i = 2; i <= s.length(); i++) { // 길이 2부터
            for (int j = 0; j + i - 1 < s.length(); j++) {
                int l = j;
                int r = j + i - 1;
                
                dp[l][r] = Math.max(dp[l][r - 1], dp[l + 1][r]);
                
                if (s.charAt(l) == s.charAt(r)) {
                    dp[l][r] = Math.max(dp[l][r], dp[l + 1][r - 1] + 2);
                }
            }
        }
        
        return dp[0][s.length() - 1];
    }
}