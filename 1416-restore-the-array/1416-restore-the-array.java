class Solution {
    public int numberOfArrays(String s, int k) {
        int m = Integer.toString(k).length();
        int n = s.length();
        long[] dp = new long[n + 1];        
        int MOD = (int) Math.pow(10, 9) + 7;
        dp[n] = 1;
        
        for (int i = n - 1; 0 <= i; i--) { // 끝자리부터
            if (s.charAt(i) == '0') {
                continue;
            }
            
            long now = 0;            
            int ll = Long.toString(now).length();        
            
            for (int j = i; j < Math.min(i + m, n); j++) {
                now *= 10;
                now += (s.charAt(j) - '0'); 
                
                if (1 <= now && now <= k) { // 이게 가능하면, 뒤에 있는 것들 계속
                    dp[i] = (dp[i] + dp[j + 1]) % MOD;
                }                        
            }
        }    
    
        return ((int) dp[0]) % MOD;
    }
}