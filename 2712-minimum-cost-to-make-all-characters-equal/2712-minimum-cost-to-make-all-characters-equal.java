class Solution {
    public long minimumCost(String s) {
        if (s.length() == 1) {
            return 0;
        }
        
        long ans = 0L;
        int i = 1;
        int j = s.length() - 2;
        
        while (i < j) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                ans += i;
            }
            
            if (s.charAt(j) != s.charAt(j + 1)) {
                ans += (s.length() - 1 - j);
            }
            
            i++;
            j--;
        }
        
        if (i != j && s.charAt(i) != s.charAt(j)) {
            ans += i;
        }
        
        if (i == j) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                ans += i;
            }
            
            if (s.charAt(j) != s.charAt(j + 1)) {
                ans += (s.length() - 1 - j);
            }
        }
        
        return ans;
    }
}