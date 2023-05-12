class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        
        for (int i = dp.length - 1; 0 <= i; i--) {
            int j = i + questions[i][1] + 1;
            long nextValue = j < dp.length ? dp[j] : 0;
            dp[i] = Math.max(questions[i][0] + nextValue, i + 1 < dp.length ? dp[i + 1] : 0);
        }        
        
        return dp[0];
    }
}