class Solution {
    Set<String> dict;
    Set<String> formWord;
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        dict = new HashSet<>(Arrays.asList(words));
        List<String> answer = new ArrayList<>();
        formWord = new HashSet<>();
        
        for (String word : words) {
            if (canBeForm(word)) {
                answer.add(word);
            }
        }
        
        return answer;
    }
    
    public boolean canBeForm(String word) {
        if (formWord.contains(word)) {
            return true;
        }
        
        for (int i = 1; i < word.length(); i++) {
            String s1 = word.substring(0, i);
            String s2 = word.substring(i);
            
            if (dict.contains(s1)) {
                if (dict.contains(s2) || canBeForm(s2)) {
                    formWord.add(word);
                    return true;
                }
            }
        }
        
        return false;
    }
}