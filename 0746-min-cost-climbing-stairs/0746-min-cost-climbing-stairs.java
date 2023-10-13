class Solution {

    public int[] nums;
    public int[] dp;

    public int dfs(int index) {
        if (nums.length <= index) {
            return 0;
        }
        
        if (dp[index] != Integer.MAX_VALUE) {
            return dp[index];
        }

        for (int i = 1; i <= 2; i++) {
            dp[index] = Math.min(dfs(index + 1), dfs(index + 2)) + nums[index];
        }

        return dp[index];
    }

    public int minCostClimbingStairs(int[] cost) {
        this.nums = cost;
        this.dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return Math.min(dfs(0), dfs(1));
    }
    
}