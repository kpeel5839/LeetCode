class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = goal.charAt(i);
            
            if (c1 != c2) {
                count++; 
            }

            m1.put(c1, m1.getOrDefault(c1, 0) + 1);
            m2.put(c2, m2.getOrDefault(c2, 0) + 1);
        }

        if (m1.size() != m2.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : m1.entrySet()) {
            Character key = entry.getKey();
            
            if (!m2.containsKey(key) || !entry.getValue().equals(m2.get(key))) {
                return false;    
            }
        }

        if (count == 0) {
            for (Integer v : m1.values()) {
                if (v >= 2) {
                    return true; 
                }
            }
        }

        if (count == 2) {
            return true; 
        }
        
        return false;
    }
}