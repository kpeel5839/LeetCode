class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> mapLetterToWord = new HashMap<>();
        Set<String> words = new HashSet<>();
        String[] word = s.split(" ");
        
        if (word.length != pattern.length()) {
            return false;
        }
        
        for (int i = 0; i < word.length; i++) {
            char character = pattern.charAt(i);
            
            if (mapLetterToWord.containsKey(character)) {
                if (!word[i].equals(mapLetterToWord.get(character))) {
                    return false;
                }
            } else {
                if (words.contains(word[i])) {
                    return false;
                }
                mapLetterToWord.put(character, word[i]);
                words.add(word[i]);
            }
        }
        
        return true;
    }
}