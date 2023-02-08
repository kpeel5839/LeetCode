class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 100_000_000);
        dp[nums.length - 1] = 0;
        
        for (int i = nums.length - 2; i != -1; i--) {        
            for (int j = 1; j <= Math.min(nums[i], nums.length - 1 - i); j++) {
                if (nums[i + j] != 0 || (i + j) == (nums.length - 1)) {                                    
                    dp[i] = Math.min(dp[i], dp[i + j] + 1);   
                }            
            }
        }
    
        return dp[0];
    }
}