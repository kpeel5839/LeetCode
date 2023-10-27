class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int[] range = new int[] {0, 0};

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 2; i <= n; i++) { 
            for (int j = 0; j + i <= n; j++) {
                if (i == 2 && c[j] == c[j + 1]) {
                    dp[j][j + 1] = true;
                } else if (i != 2 && c[j] == c[j + i - 1] && dp[j + 1][j + i - 2]) {
                    dp[j][j + i - 1] = true;
                }
                
                if (dp[j][j + i - 1] && (range[1] - range[0] + 1) < i) {
                    range = new int[] {j, j + i - 1};
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = range[0]; i <= range[1]; i++) {
            ans.append(c[i]); 
        }

        return ans.toString();
    }
}