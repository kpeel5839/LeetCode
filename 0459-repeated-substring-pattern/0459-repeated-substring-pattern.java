class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        
        for (int i = 1; i <= n / 2; i++) {
            if (n % i != 0) {
                continue;
            }
            
            int count = 0;
            Set<String> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();        
            
            for (int j = 0; j < n; j++) {
                count++;
                sb.append(s.charAt(j));
                
                if (count == i) {
                    set.add(sb.toString());
                    
                    if (set.size() == 2) {
                        break;
                    }
                    
                    sb = new StringBuilder();
                    count = 0;
                }
            }
            
            if (set.size() == 1) {
                return true;
            }
        }
        
        return false;
    }
}