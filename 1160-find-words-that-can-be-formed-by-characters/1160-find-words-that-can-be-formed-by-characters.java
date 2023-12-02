class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        
        for (int i = 0; i < chars.length(); i++) {
            count[chars.charAt(i) - 'a']++;
        }
        
        int answer = 0;
        
        Loop:
        for (int i = 0; i < words.length; i++) {
            int[] cc = new int[26];
            
            for (int j = 0; j < words[i].length(); j++) {
                cc[words[i].charAt(j) - 'a']++;
            }
            
            for (int j = 0; j < 26; j++) {
                if (count[j] < cc[j]) {
                    continue Loop;
                }
            }
            
            answer += words[i].length();
        }
        
        return answer;
    }
}