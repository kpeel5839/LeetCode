class Solution {
    public int countHomogenous(String s) {
        char pre = '1';
        int count = 0;
        int ans = 0;
        final int MOD = 1_000_000_007;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (pre == c) {
                count++;
            } else {
                count = 1;
                pre = c;
            }
            
            ans = (ans + count) % MOD;
        }
        
        return ans;
    }
}