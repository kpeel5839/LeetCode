class Solution {
    int[] parent;
    
    int find(int a) {
        if (parent[a] == a) {
            return a;
        } 
        return parent[a] = find(parent[a]);
    }
    
    void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[b] = a;
    }
    
    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        
        if (connections.length < (n - 1)) {
            return -1;
        }
    
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < connections.length; i++) {
            int a = find(connections[i][0]);
            int b = find(connections[i][1]);
            union(a, b);
        }
        
        Set<Integer> p = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            p.add(find(parent[i]));
        }
        
        return p.size() - 1;
    }
}