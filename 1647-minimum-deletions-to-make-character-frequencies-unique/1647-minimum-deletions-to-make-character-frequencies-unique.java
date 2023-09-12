class Solution {
    public Map<Character, Integer> m = new HashMap<>();
    public int minDeletions(String s) {
        int n = s.length();
        int[] count = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (!m.containsKey(c)) {
                m.put(c, 0);
            }
            
            m.put(c, m.get(c) + 1);
        }
        
        int max = 0;
        
        for (Integer next : m.values()) {
            count[next]++;
            max = Math.max(max, next);
        }
        
        int ans = 0;
        for (int i = max; 0 < i; i--) {
            if (1 < count[i]) {
                int value = count[i] - 1;
                count[i - 1] += value;
                ans += value;
            }
        }
        
        return ans;
    }
}