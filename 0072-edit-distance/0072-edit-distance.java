class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] d = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            d[i][0] = i;    
        }
        
        for (int i = 1; i <= n; i++) {
            d[0][i] = i;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    d[i][j] = d[i - 1][j - 1];
                } else {
                    d[i][j] = Math.min(d[i - 1][j - 1], Math.min(d[i - 1][j], d[i][j - 1])) + 1;
                }
            }
        }
        
        return d[m][n];
    }
}