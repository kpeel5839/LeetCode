class Solution {
    
    public int maxDistance;
    public int[][] roads;
    public int n;
    public int INF = 100_000;
    
    public boolean isPossible(int bit) {
        if (bit == 0) {
            return true;
        }
        
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }
        
        for (int[] r : roads) {
            if ((bit & (1 << r[0])) == 0 || (bit & (1 << r[1])) == 0) {
                continue;
            }
            
            dp[r[0]][r[1]] = Math.min(dp[r[0]][r[1]], r[2]);
            dp[r[1]][r[0]] = Math.min(dp[r[1]][r[0]], r[2]);
        }
        
        for (int k = 0; k < n; k++) { 
            for (int i = 0; i < n; i++) { 
                if ((bit & (1 << k)) == 0 || (bit & (1 << i)) == 0) {
                    continue;
                }
                
                for (int j = 0; j < n; j++) { 
                    if ((bit & (1 << j)) == 0) {
                        continue;
                    }
                    
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((bit & (1 << i)) == 0 || (bit & (1 << j)) == 0) {
                    continue;
                }
                
                if (maxDistance < dp[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
        
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        this.n = n;
        this.maxDistance = maxDistance;
        this.roads = roads;
        int answer = 0;
        
        for (int i = 0; i < 1 << n; i++) {
            answer += isPossible(i) ? 1 : 0;
        }
        
        return answer;
    }
}