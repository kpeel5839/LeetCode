class Solution {

    public int[] nums1;
    public int[] nums2;
    public int[][] dp;

    public int dfs(int i1, int i2) {
        if (i1 == nums1.length || i2 == nums2.length) {
            return 0;
        }

        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }

        int result = nums1[i1] * nums2[i2];

        if (0 < result) {
            dp[i1][i2] = Math.max(dp[i1][i2], dfs(i1 + 1, i2 + 1)) + result;
        }

        dp[i1][i2] = Math.max(dp[i1][i2], dfs(i1 + 1, i2));
        dp[i1][i2] = Math.max(dp[i1][i2], dfs(i1, i2 + 1));
        
        return dp[i1][i2];
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        dp = new int[nums1.length][nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int result = dfs(0, 0);

        if (result == 0) {
            int ans = Integer.MIN_VALUE;

            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    ans = Math.max(ans, nums1[i] * nums2[j]);
                }
            }

            result = ans;
        }
        
        return result;
    } 
}