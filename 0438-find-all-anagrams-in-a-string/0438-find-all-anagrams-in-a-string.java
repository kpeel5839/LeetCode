class Solution {
    public List<Integer> findAnagrams(String s2, String s1) {
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        
        for (int i = 0; i < 'z' - 'a' + 1; i++) {
            s1Map.put((char) ('a' + i), 0);
            s2Map.put((char) ('a' + i), 0);
        }
        
        for (int i = 0; i < s1.length(); i++) {
            char nowChar = s1.charAt(i);
            s1Map.put(nowChar, s1Map.get(nowChar) + 1);
        }
        
        int left = 0;
        int sum = 0;
        List<Integer> answer = new ArrayList<>();
    
        for (int i = 0; i < s2.length(); i++) {
            char nowChar = s2.charAt(i);
            
            if (s1Map.get(nowChar) == 0) {
                for (int j = 0; j < 'z' - 'a' + 1; j++) {
                    s2Map.put((char) ('a' + j), 0);
                }
                
                sum = 0;
                left = i + 1;
                continue;
            }
            
            while (s1Map.get(nowChar) < s2Map.get(nowChar) + 1) {
                char leftChar = s2.charAt(left);
                s2Map.put(leftChar, s2Map.get(leftChar) - 1);
                left++;
                sum--;
            }
            
            s2Map.put(nowChar, s2Map.get(nowChar) + 1);
            sum++;
            
            if (sum == s1.length()) { // 전부 맞은 경우
                char leftChar = s2.charAt(left);
                s2Map.put(leftChar, s2Map.get(leftChar) - 1);
                left++;
                sum--;
                answer.add(i - (s1.length() - 1));
            }
        }
        
        return answer;
    }
}