class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);        
        int[] c = new int[cuts.length + 2];
        int[][] dp = new int[c.length][c.length];
        
        for (int i = 0; i < cuts.length; i++) {
            c[i + 1] = cuts[i];
        }

        c[cuts.length + 1] = n;
        
        for (int i = 1; i <= cuts.length; i++) {
            dp[i][i] = c[i + 1] - c[i - 1];        
        }    

        for (int i = 2; i <= cuts.length; i++) {
            for (int j = 1; j + i - 1 <= cuts.length; j++) {                
                int min = Integer.MAX_VALUE;

                for (int k = j; k <= j + i - 1; k++) {
                    if (k == j) {
                        min = Math.min(min, dp[k + 1][j + i - 1]);
                    } else if (k == j + i - 1) {
                        min = Math.min(min, dp[j][k - 1]);
                    } else {
                        min = Math.min(min, dp[j][k - 1] + dp[k + 1][j + i - 1]);
                    }
                }

                dp[j][j + i - 1] = min + (c[j + i] - c[j - 1]);
            }
        }

        return dp[1][cuts.length];
    }
}