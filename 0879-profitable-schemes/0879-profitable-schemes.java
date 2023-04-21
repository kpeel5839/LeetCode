class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD = (int) Math.pow(10, 9) + 7;
        Map<Integer, Long>[] dp = new HashMap[n + 1];
        
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashMap<>();
        }
        
        dp[0].put(0, 1L);
        
        for (int i = 0; i < group.length; i++) {                                
            for (int j = dp.length - 1 - group[i]; 0 <= j; j--) { // 근데, 여기서             
                int ii = j + group[i];            
                
                for (Map.Entry<Integer, Long> v : dp[j].entrySet()) {
                    int key = v.getKey();
                    long value = v.getValue();
                    int newKey = Math.min(minProfit, key + profit[i]);  
                    dp[ii].put(newKey, (dp[ii].getOrDefault(newKey, 0L) + value) % MOD);
                    // mm[ii].put(newKey, (mm[ii].getOrDefault(newKey, 0L) + value) % MOD);                
                }                
            }
            
        
        }
        
        long ans = 0;
        
        for (int i = 0; i < dp.length; i++) {               
            ans += (long) (dp[i].getOrDefault(minProfit, 0L) % MOD);        
        }
        
        return (int) (ans % MOD);
    }
}