class Solution {
    public int countHomogenous(String s) {
        char[] c = s.toCharArray();
        char pre = '1';
        int count = 0;
        int ans = 0;
        final int MOD = 1_000_000_007;
        
        for (int i = 0; i < s.length(); i++) {
            if (pre == c[i]) {
                count++;
            } else {
                count = 1;
                pre = c[i];
            }
            
            ans = (ans + count) % MOD;
        }
        
        return ans;
    }
}