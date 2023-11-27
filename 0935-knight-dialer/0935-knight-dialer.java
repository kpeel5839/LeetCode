class Solution {
    
    public int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    public int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    public int H = 4;
    public int W = 3;
    public int[][][] dp;
    public final int MOD = 1_000_000_007;
    public int n;
    
    public boolean isOutOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W || (y == H - 1 && (x == 0 || x == W - 1));
    }
    
    public int dfs(int moveCount, int y, int x) {
        if (isOutOfRange(y, x)) {
            return 0;
        }
        
        if (moveCount == n) {
            return 1;
        }
        
        if (dp[moveCount][y][x] != -1) {
            return dp[moveCount][y][x];
        }
        
        dp[moveCount][y][x] = 0;
        
        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            dp[moveCount][y][x] = (dp[moveCount][y][x] + dfs(moveCount + 1, ny, nx)) % MOD;
        }
        
        return dp[moveCount][y][x];
    }
    
    public int knightDialer(int n) {
        this.dp = new int[n + 1][H][W];
        this.n = n;
        int answer = 0;
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                answer = (answer + dfs(1, i, j)) % MOD;
            }
        }
        
        return answer;
    }
    
}