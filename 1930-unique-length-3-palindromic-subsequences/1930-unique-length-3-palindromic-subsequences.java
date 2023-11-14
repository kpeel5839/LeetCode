class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            int start = 100_001;
            int end = -1;
            
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                
                if (c - 'a' == i) {
                    start = Math.min(start, j);
                    end = Math.max(end, j);
                }
            }
            
            if (start == Integer.MAX_VALUE) {
                continue;
            }
            
            Set<Character> set = new HashSet<>();
            
            for (int j = start + 1; j <= end - 1; j++) {
                set.add(s.charAt(j));
            }
            
            ans += set.size();
        }
        
        return ans;
    }
}