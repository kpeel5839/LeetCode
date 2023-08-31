class Solution {
    public int ADD = 100;
    public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1 + 2 * ADD];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i <= ADD; i++) {
            dp[i] = 0;
        }

        for (int i = ADD; i < ranges.length + ADD; i++) {
            if (ranges[i - ADD] == 0) {
                continue;
            }
            
            int min = dp[i - ranges[i - ADD]];
            if (min == Integer.MAX_VALUE) {
                continue;
            }
            
            for (int j = -ranges[i - ADD]; j <= ranges[i - ADD]; j++) {
                if (i + j < ADD) {
                    continue;
                }

                dp[i + j] = Math.min(dp[i + j], min + 1);
            }
        }

        return dp[n + ADD] == Integer.MAX_VALUE ? -1 : dp[n + ADD];
    }
}