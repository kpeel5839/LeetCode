class Solution {

    public int[][] dp;
    public int H;
    public int W;
    public int[] dx = {0, 1, 0, -1};
    public int[] dy = {-1, 0, 1, 0};
    public int[][] map;

    public boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W; 
    }

    public int dfs(int y, int x) {
        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        dp[y][x] = 0;
        
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (outOfRange(ny, nx) || map[ny][nx] <= map[y][x]) {
                continue;
            }
            
            dp[y][x] = Math.max(dp[y][x], dfs(ny, nx));
        }
        
        return dp[y][x] = (dp[y][x] + 1);
    }

    public int longestIncreasingPath(int[][] matrix) {
        H = matrix.length;
        W = matrix[0].length;
        map = matrix;
        dp = new int[H][W];
        
        for (int i = 0; i < H; i++) {
            Arrays.fill(dp[i], -1);    
        }

        int ans = 0;
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        
        return ans;
    }
}