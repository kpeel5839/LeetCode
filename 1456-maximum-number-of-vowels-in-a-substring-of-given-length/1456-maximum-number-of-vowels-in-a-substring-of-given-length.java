class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> ss = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));
        int count = 0;
        int v = 0;
        int ans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            count++;
            char c = s.charAt(i);
            v += ss.contains(c) ? 1 : 0;
            
            if (k <= count) {
                ans = Math.max(ans, v);
                char cc = s.charAt(i - (k - 1));
                v += ss.contains(cc) ? -1 : 0;
            }
        }
        
        return ans;
    }
}