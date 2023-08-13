class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        for (int i = 2; i <= n; i++) {
            int a = nums[i - 1];
            int b = nums[i - 2];
            
            if (a == b) {
                dp[i] |= dp[i - 2];
            }
            
            if (i != 2) {
                int c = nums[i - 3];
                if ((c == b && b == a) || (c == b - 1 && b == a - 1)) {
                    dp[i] |= dp[i - 3];
                }
            } 
        }
        
        return dp[n];
    }
}