class Solution {
    public int totalMoney(int n) {
        int[] dp = new int[n + 1];
        int answer = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            if ((i % 7) == 1) {
                dp[i] = dp[i - 7] + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            
            answer += dp[i];
        }
        
        return answer;
    }
}