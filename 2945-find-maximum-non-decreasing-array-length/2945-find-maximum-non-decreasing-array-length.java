public class Solution {
    public int findMaximumLength(int[] nums) {
        int n = nums.length;

        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = (long) nums[i] + prefixSum[i];
        }

        int[] range = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            range[i] = Math.max(range[i], range[i - 1]);
            dp[i] = dp[range[i]] + 1;

            int l = i;
            int r = n; 
            int ans = 0;

            while (l <= r) {
                int mid = (l + r) / 2;

                if (prefixSum[mid] - prefixSum[i] < prefixSum[i] - prefixSum[range[i]]) {
                    l = mid + 1;
                } else {
                    ans = mid;
                    r = mid - 1;
                }
            }

            range[ans] = i;
        }

        return dp[n];
    }
}