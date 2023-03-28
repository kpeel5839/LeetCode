class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int index = 0;
        int[] dp = new int[396];    
        
        for (int i = 31; i < dp.length; i++) {
            if (index == days.length) {
                break;    
            }
            if (days[index] == i - 30) { // 이때 진행해야함
                index++;
                dp[i] = Math.min(dp[i - 1] + costs[0], Math.min(dp[i - 7] + costs[1], dp[i - 30] + costs[2]));
            } else {
                dp[i] = dp[i - 1];
            }
        }
        
        return dp[days[index - 1] + 30];
    }
}