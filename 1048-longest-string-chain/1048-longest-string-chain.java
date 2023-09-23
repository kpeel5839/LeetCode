class Solution {
    
    public Map<Integer, int[]> boundary = new HashMap<>();
    
    public boolean isPossible(String s1, String s2) {
        int index = 0;
          
        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(index) == s2.charAt(i)) {
                index++;
            }
            
            if (s1.length() == index) {
                return true;
            }
        }
        
        return false;
    }
    
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        
        for (int i = 0; i < words.length; i++) {
            int v = words[i].length();
            
            if (!boundary.containsKey(v)) {
                boundary.put(v, new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE});
            }
            
            int[] now = boundary.get(v);
            now[0] = Math.min(now[0], i);
            now[1] = Math.max(now[1], i);
        }
        
        int n = words.length; 
        int[] dp = new int[n];
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            int l = words[i].length();
            int max = 0;
            int[] now = boundary.getOrDefault(l - 1, new int[] {1, 0});
            
            for (int j = now[0]; j <= now[1]; j++) {
                if (isPossible(words[j], words[i])) {
                    max = Math.max(max, dp[j]);
                }
            }
            
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }
                
        return ans;
    }
}