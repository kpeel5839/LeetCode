class Solution {
    public Map<String, Boolean> m = new HashMap<>();
    
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        
        if (s1.equals(s2)) {
            return true;
        }
        
        if (n == 1) {
            return false;
        }
        
        String key = s1 + " " + s2;
        
        if (m.containsKey(key)) {
            return m.get(key);
        }
        
        for (int i = 1; i < n; i++) {
            boolean a = isScramble(s1.substring(0, i), s2.substring(0, i)) 
                && isScramble(s1.substring(i), s2.substring(i));
            
            if (a) {
                m.put(key, true);
                return true;
            }
            
            boolean b = isScramble(s1.substring(0, i), s2.substring(n - i))
                && isScramble(s1.substring(i), s2.substring(0, n - i));
            
            if (b) {
                m.put(key, true);
                return true;
            }
        }
        
        m.put(key, false);
        return false;
    }
}