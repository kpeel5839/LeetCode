class Solution {
    public int[] dy = {-1, 0, 1};
    public int[][] dp;
    public int h;
    public int w;
    public int ans;
    
    public boolean outOfRange(int y, int x) {
        return y < 0 || y >= h || x < 0 || x >= w;
    }
    
    public int dfs(int y, int x, int[][] grid) {         
        if (dp[y][x] != -1) {
            return dp[y][x];
        }
        
        dp[y][x] = 0;
        
        for (int i = 0; i < 3; i++) {
            int ny = y + dy[i];
            int nx = x + 1;
            
            if (outOfRange(ny, nx) || grid[ny][nx] <= grid[y][x]) {
                continue;
            }
            
            dp[y][x] = Math.max(dp[y][x], dfs(ny, nx, grid));
        }
        
        return dp[y][x] + 1;
    }
    
    public int maxMoves(int[][] grid) {
        h = grid.length;
        w = grid[0].length;
        dp = new int[h][w];
        
        for (int i = 0; i < h; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        int ans = 0;
        for (int i = 0; i < h; i++) {
            ans = Math.max(ans, dfs(i, 0, grid));
        }
        
        return ans - 1;
    }
}