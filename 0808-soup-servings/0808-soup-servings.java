class Solution {
    public double[][] dp;
    public int[] diffA = new int[] {100, 75, 50, 25};
    public int[] diffB = new int[] {0, 25, 50, 75};
    
    public double dfs(int a, int b) {
        if (a == 0 && b == 0) {
            return 0.5;
        } else if (a == 0) {
            return 1;
        } else if (b == 0) {
            return 0;
        }

        if (dp[a][b] != -1) {
            return dp[a][b];     
        }

        dp[a][b] = 0;

        for (int i = 0; i < 4; i++) {
            int na = a - diffA[i];
            int nb = b - diffB[i];
            
            dp[a][b] += 0.25 * dfs(Math.max(0, na), Math.max(0, nb));
        }

        return dp[a][b];
    }

    public double soupServings(int n) {
        if (n > 4800) { // 4800 을 넘어가면 A 가 먼저 비워질 확률이 1에 정말 가까워짐
            return 1;
        } 

        dp = new double[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return dfs(n, n);
    }
}