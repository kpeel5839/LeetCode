class Trie {
    
    public Node root;
    
    class Node {
        char v;
        boolean f;
        Node[] next;
        
        Node() {
            f = false;
            next = new Node[26];
        }
        
        Node(char v) {
            this();
            this.v = v;
        }
    }

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node c = root;
        
        for (int i = 0; i < word.length(); i++) {
            char cc = word.charAt(i);
            
            if (c.next[cc - 'a'] == null) {
                c.next[cc - 'a'] = new Node(cc);
            }
            
            c = c.next[cc - 'a'];
        }
        
        c.f = true;
    }
    
    public boolean search(String word) {
        Node c = root;
        
        for (int i = 0; i < word.length(); i++) {
            char cc = word.charAt(i);
        
            if (c.next[cc - 'a'] == null) {
                return false;
            }
            
            c = c.next[cc - 'a'];
        }
        
        return c.f;
    }
    
    public boolean startsWith(String prefix) {
        Node c = root;
        
        for (int i = 0; i < prefix.length(); i++) {
            char cc = prefix.charAt(i);
            
            if (c.next[cc - 'a'] == null) {
                return false;
            }
            
            c = c.next[cc - 'a'];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */