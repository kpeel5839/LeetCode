class Solution {
    public int numWays(String[] words, String target) {            
        int wl = words[0].length();
        int tl = target.length();        
        int ll = wl - tl + 1;
        int MOD = (int) Math.pow(10, 9) + 7;
        
        // if (ll <= 0) {
        //     return 0;
        // }
        
        Map<Character, Integer>[] mm = new HashMap[wl];
        long[][] dp = new long[tl][wl + 1];
        
        for (int i = 0; i < mm.length; i++) {
            mm[i] = new HashMap<Character, Integer>();
            
            for (int j = 0; j < words.length; j++) {
                char c = words[j].charAt(i);
                mm[i].put(c, mm[i].getOrDefault(c, 0) + 1);                
            }
        }
        
        for (int i = (tl - 1) + (ll - 1); tl - 1 <= i; i--) {
            char c = target.charAt(tl - 1);
            dp[tl - 1][i] = dp[tl - 1][i + 1] + mm[i].getOrDefault(c, 0);
        }
        
        for (int i = tl - 2; 0 <= i; i--) {
            for (int j = i + (ll - 1); i <= j; j--) {
                dp[i][j] = (((mm[j].getOrDefault(target.charAt(i), 0) * dp[i + 1][j + 1]) % MOD) + dp[i][j + 1]) % MOD;
            }
        }
        
        return (int) dp[0][0] % MOD;
    }
}