class Solution {
    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int[] count = new int[n + 1];
        Set<Character> set = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));
        
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            count[i] = count[i - 1];
            
            if (set.contains(c)) {
                count[i]++;
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 2; i + j - 1 <= n; j += 2) {
                int vowelCount = count[i + j - 1] - count[i - 1];
                
                if (vowelCount == j - vowelCount && (vowelCount * (j - vowelCount) % k) == 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}