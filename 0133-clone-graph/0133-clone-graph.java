/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Map<Integer, Node> m = new HashMap<>();
    public Set<Integer> v = new HashSet<>();
    
    public void dfs(Node c) {
        if (c == null) {
            return;
        }
        
        m.put(c.val, new Node(c.val));
        v.add(c.val);
        
        for (Node next : c.neighbors) {
            if (!v.contains(next.val)) {
                dfs(next);
            }   
        }
        
        for (Node next : c.neighbors) {
            m.get(c.val).neighbors.add(m.get(next.val));
        }
    }
    
    public Node cloneGraph(Node node) {
        dfs(node);
        
        return m.getOrDefault(1, null);
    }
}