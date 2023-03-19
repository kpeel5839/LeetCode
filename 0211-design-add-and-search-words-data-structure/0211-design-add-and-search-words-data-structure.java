class WordDictionary {
    
    class Node {
        char c;
        Map<Character, Node> m;
        boolean f;
        
        Node() {
            m = new HashMap<>();
            f = false;
        }
        
        Node(char c) {
            this();
            c = c;
        }
    }
    
    Node r;

    public WordDictionary() {
        r = new Node();    
    }
    
    public void addWord(String word) {
        Node c = r;
        
        for (int i = 0; i < word.length(); i++) {
            char cc = word.charAt(i);
            
            if (!c.m.containsKey(cc)) {
                c.m.put(cc, new Node(cc));
            }
            
            c = c.m.get(cc);
        }
    
        c.f = true;
    }
    
    public boolean search(String word) {
        return ss(r, word, 0);
    }

    public boolean ss(Node c, String word, int index) {
        if (word.length() == index) {
            return c.f;
        }
        
        char cc = word.charAt(index);
        
        if (cc == '.') {
            for (Node n : c.m.values()) {
                if (ss(n, word, index + 1)) {
                    return true;
                }
            }
        } else if (c.m.containsKey(cc)) {
            if (ss(c.m.get(cc), word, index + 1)) {
                return true;
            }
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */