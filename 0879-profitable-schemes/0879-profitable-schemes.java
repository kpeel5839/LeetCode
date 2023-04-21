class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        // 추가하는 경우와, 추가하지 않는 경우, 이 때 minProfit 을 넘지 않도록 하는 것이 관건이다.
        int MOD = (int) Math.pow(10, 9) + 7;
        Map<Integer, Long>[] dp = new HashMap[n + 1];
        
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashMap<>();
        }
        
        dp[0].put(0, 1L);
        
        for (int i = 0; i < group.length; i++) {        
            Map<Integer, Long>[] mm = new HashMap[n + 1];
            
            for (int c = 0; c < dp.length; c++) {
                mm[c] = new HashMap<>();    
            }
            
            for (int j = 0; j + group[i] < dp.length; j++) { // 근데, 여기서             
                int ii = j + group[i];            
                
                for (Map.Entry<Integer, Long> v : dp[j].entrySet()) {
                    int key = v.getKey();
                    long value = v.getValue();
                    int newKey = Math.min(minProfit, key + profit[i]);                
                    mm[ii].put(newKey, (mm[ii].getOrDefault(newKey, 0L) + value) % MOD);                
                }                
            }
            
            for (int c = 0; c < dp.length; c++) {
                for (Map.Entry<Integer, Long> v : mm[c].entrySet()) {
                    int key = v.getKey();
                    long value = v.getValue();
                    dp[c].put(key, (dp[c].getOrDefault(key, 0L) + value) % MOD);
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