class Solution {
    public Trie root = new Trie();
    
    public class Trie {
        Trie[] next;
        boolean isEnd;
        
        Trie() {
            next = new Trie[26]; // 일단은 각각의 배열은 null 로 존재하는 상태
            isEnd = false; // false 로
        }
    }
    
    public void insert(String word) {
        Trie current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            
            if (current.next[index] == null) {
                current.next[index] = new Trie();
            }
            
            current = current.next[index];
        }
        
        current.isEnd = true;
    }
    
    public boolean dfs(String word, int index, int count) {
        if (index >= word.length()) {
            return count >= 2; // 성공하는 경우
        }
        
        Trie current = root;
        
        for (int i = index; i < word.length(); i++) {
            // 여기서 출발
            int pos = word.charAt(i) - 'a';
            
            if (current.next[pos] == null) {
                return false;
            }
            
            current = current.next[pos];
            
            if (current.isEnd) {
                if (dfs(word, i + 1, count + 1)) {
                    return true; // 여기서 return true 한번 나면, 바로 그냥 끝나는 것
                }
            }
        }
        
        return false;
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {    
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        
        List<String> answer = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            if (dfs(words[i], 0, 0)) {
                answer.add(words[i]);
            }
        }
        
        return answer;
    }
}