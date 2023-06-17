class Solution {
    
    public int[] A;
    public int[] B;
    public int[][] dp;
    public final int INF = 1_000_000_000; 
    
    public int dfs(int i, int j, int v) {
        if (i == A.length) {
            return 0;
        }

        j = search(j, B.length - 1, v);

        if (dp[i][j] != INF) {
            return dp[i][j];
        }

        int take = INF + 1;
        int notTake = INF + 1;
        
        if (j != B.length) {
            take = dfs(i + 1, j + 1, B[j]) + 1;
        }
        
        if (v < A[i]) {
            notTake = dfs(i + 1, j, A[i]);
        }

        return dp[i][j] = Math.min(take, notTake);
    }
    
    public int search(int a, int b, int v) {
        int l = a;
        int r = b;
        int result = B.length;
        
        while (l <= r) {
            int m = (l + r) / 2;
            
            if (v < B[m]) {
                result = m;
                r = m - 1; 
            } else {
                l = m + 1;
            }
        }

        return result;
    }
    
    public int makeArrayIncreasing(int[] arr1, int[] arr2) { 
        this.A = arr1;
        this.B = arr2;
        Arrays.sort(B);
        dp = new int[A.length][B.length + 1];

        for (int i = 0; i < A.length; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        int result = dfs(0, 0, -1);

        return result == INF + 1 ? -1 : result;
    }
}