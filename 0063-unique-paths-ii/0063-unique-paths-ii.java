class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int H = obstacleGrid.length;
        int W = obstacleGrid[0].length;
        int[][] dp = new int[H + 1][W + 1];
        dp[1][1] = obstacleGrid[0][0] == 0 ? 1 : 0;
        
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if (i == 1 && j == 1 || obstacleGrid[i - 1][j - 1] == 1) {
                    continue;
                }         
                
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[H][W];
    }
}