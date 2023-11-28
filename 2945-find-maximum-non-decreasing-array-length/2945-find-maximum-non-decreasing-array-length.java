public class Solution {
    public int findMaximumLength(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = nums[i] + prefixSum[i];
        }
        
        int[] range = new int[n + 1];
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            range[i] = Math.max(range[i], range[i - 1]);
            dp[i] = dp[range[i]] + 1;
            
            int l = i;
            int r = n;
            int ans = 0;
            
            while (l <= r) {
                int m = (l + r) / 2;
                
                if (prefixSum[m] - prefixSum[i] < prefixSum[i] - prefixSum[range[i]]) {
                    l = m + 1;
                } else {
                    ans = m;
                    r = m - 1;
                }
            }
            
            range[ans] = i;
        }
        
        return dp[n];
    }
}