class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n + 1];        
        Set<String> d = new HashSet<>();
        int value = 1;
        
        for (int i = n - 1; 0 <= i; i--) {
            dp[i] = value++;
        }
        
        for (int i = 0; i < dictionary.length; i++) {
            d.add(dictionary[i]);
        }
        
        for (int i = n - 1; 0 <= i; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; j++) {
                sb.append(s.charAt(j));            
                
                if (d.contains(sb.toString())) { // 있으면 0 으로
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                } else { // 없으면 문자열 길이만큼으로 i - j + 1;
                    dp[i] = Math.min(dp[i], j - i + 1 + dp[j + 1]);
                }
            }    
        }    
        
        return dp[0];
    }
}