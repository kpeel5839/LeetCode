class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int answer = -1;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            m.put(c, Math.min(m.getOrDefault(c, Integer.MAX_VALUE), i));
            answer = Math.max(answer, i - m.get(c) - 1);
        }
        
        return answer;
    }
}