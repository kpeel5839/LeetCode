class Solution {
    public int sum;
    public int[] nums;
    public int[][][] dp;

    public int dfs(int turn, int l, int r) {
        if (r < l) {
            return 0;
        }

        if (dp[turn][l][r] != -1) {
            return dp[turn][l][r];
        }

        int chooseLeft = dfs((turn + 1) % 2, l, r - 1) + (turn == 0 ? nums[r] : 0);
        int chooseRight = dfs((turn + 1) % 2, l + 1, r) + (turn == 0 ? nums[l] : 0);

        if (turn == 0) { 
            dp[turn][l][r] = Math.max(chooseLeft, chooseRight);
        } else { 
            dp[turn][l][r] = Math.min(chooseLeft, chooseRight);
        }

        return dp[turn][l][r];
    }

    public boolean PredictTheWinner(int[] nums) {
        this.nums = nums;
        dp = new int[2][nums.length][nums.length];
        
        sum = Arrays.stream(nums)
            .sum();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < nums.length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        } 

        int player1Score = dfs(0, 0, nums.length - 1);
        int player2Score = sum - player1Score;

        return player1Score >= player2Score;
    }
}