class Solution {
    public int maxProfit(int[] prices, int fee) {
        int ans = 0; 
        int max = 0;
        int min = prices[0];
        int minIndex = 0; 
        int[] dp = new int[prices.length];
    
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i]);

            if (prices[i - 1] - prices[i] >= fee || fee < max - prices[i]) {
                max = prices[i];
                minIndex = i;
            }
            
            if (prices[i] < prices[minIndex]) {
                minIndex = i;
            }

            dp[i] = Math.max(ans, prices[i] - prices[minIndex] - fee + (minIndex == 0 ? 0 : dp[minIndex - 1]));
            ans = dp[i]; 
        }

        return ans;
    }
}