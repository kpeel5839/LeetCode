class Solution {
    public long MOD = ((long) Math.pow(10, 9)) + 7;
    public long[][][] dp;
    public long[][] count;
    public int h;
    public int w;
    public int goal;
    
    public long dfs(int k, int y, int x) {
        if (goal == k) {
            return 1;
        }
        
        if (dp[k][y][x] != -1) {
            return dp[k][y][x];
        }
        
        dp[k][y][x] = 0;
        
        for (int i = x + 1; i < w; i++) { // 세로
            long left = count[y][x] - count[y][i];
            long right = count[y][i];
            
            if (left != 0 && right != 0) { // 둘다 0이 아닐때만 가능
                dp[k][y][x] += ((dfs(k + 1, y, i) % MOD) % MOD);
            }
        }
        
        for (int i = y + 1; i < h; i++) { // 가로
            long up = count[y][x] - count[i][x];
            long down = count[i][x];
            
            if (up != 0 && down != 0) {
                dp[k][y][x] += ((dfs(k + 1, i, x) % MOD) % MOD);
            }
        }
        
        return dp[k][y][x] = dp[k][y][x] % MOD;
    }
    
    public int ways(String[] pizza, int k) {
        h = pizza.length;
        w = pizza[0].length();
        goal = k - 1;
        count = new long[h][w];
        count[h - 1][w - 1] = pizza[h - 1].charAt(w - 1) == 'A' ? 1 : 0;
        dp = new long[goal][h][w];
        
        for (int i = 0; i < goal; i++) {
            for (int j = 0; j < h; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        for (int i = w - 2; i != -1; i--) {
            count[h - 1][i] = (pizza[h - 1].charAt(i) == 'A' ? 1 : 0) + count[h - 1][i + 1];
        }
        
        for (int i = h - 2; i != -1; i--) {
            count[i][w - 1] = (pizza[i].charAt(w - 1) == 'A' ? 1 : 0) + count[i + 1][w - 1];
        }
        
        for (int i = h - 2; i != -1; i--) {
            for (int j = w - 2; j != -1; j--) {
                count[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0) + count[i + 1][j] + count[i][j + 1] - count[i + 1][j + 1];            
            }
        }    
        
        return (int) (dfs(0, 0, 0) % MOD);
    }
}