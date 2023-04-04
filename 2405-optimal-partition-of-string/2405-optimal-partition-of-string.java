class Solution {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (set.contains(c)) {
                ans++;
                set.clear();
            }
            
            set.add(c);
        }
        
        return set.size() == 0 ? ans : ans + 1;
    }
}