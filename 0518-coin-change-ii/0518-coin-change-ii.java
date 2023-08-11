class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][5000 + 1];

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] += dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }
            } 
        }
        
        return dp[coins.length][amount];
    }
}