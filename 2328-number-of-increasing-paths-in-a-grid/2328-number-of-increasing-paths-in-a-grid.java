class Solution {
    
    public int[][] dp;
    public int[][] grid;
    public final int MOD = 1_000_000_007;
    public int[] dx = {0, 1, 0, -1};
    public int[] dy = {-1, 0, 1, 0};
    public int H;
    public int W;
    
    public boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    } 
    
    public int dfs(int y, int x) {
        if (dp[y][x] != -1) {
            return dp[y][x]; 
        }
        
        dp[y][x] = 1;
        
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if (outOfRange(ny, nx) || grid[ny][nx] <= grid[y][x]) {
                continue;
            }
            
           dp[y][x] = (dp[y][x] + dfs(ny, nx)) % MOD;
        }
        
        return dp[y][x] % MOD;
    }
    
    public int countPaths(int[][] grid) {
        H = grid.length;
        W = grid[0].length;
        dp = new int[H][W];
        this.grid = grid;
        
        for (int i = 0; i < H; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        int ans = 0;
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                ans = (ans + dfs(i, j)) % MOD;
            }
        }
        
        return ans;
    }
}