class Solution {
    public int longestArithSeqLength(int[] nums) {
        int[][] dp = new int[1001][nums.length];
        final int INDEXING = 500;
        int ans = 2;
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; 0 <= j; j--) {
                int diff = nums[i] - nums[j] + INDEXING;
                dp[diff][i] = Math.max(dp[diff][i], dp[diff][j] + 1);
                ans = Math.max(ans, dp[diff][i] + 1);
            }
        }
        
        return ans;
    }
}