class Solution {
    
    public int[][] dp;
    public int[] nums;
    
    public int dfs(int pre, int index) {
        if (index == nums.length) {
            return 0;
        }
        
        if (dp[pre][index] != -1) {
            return dp[pre][index];
        }
        
        if (pre != 1) {
            dp[pre][index] = dfs(1, index + 1) + nums[index];
        }
        
        dp[pre][index] = Math.max(dp[pre][index], dfs(0, index + 1));
        return dp[pre][index];
    }
    
    public int rob(int[] nums) {
        this.nums = nums;
        dp = new int[2][nums.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return dfs(0, 0); 
    }
}