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
        
        if (a != b) {
            parent[b] = a;   
        }    
    }
    
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int[] node : edges) {
            union(node[0], node[1]);
        }
        
        Map<Integer, Long> m = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            m.put(find(parent[i]), m.getOrDefault(find(parent[i]), 0L) + 1);
        }
        
        long ans = 0;
        List<Long> l = new ArrayList<>(m.values());
        
        long count = 0;
        for (int i = 0; i < l.size() - 1; i++) {
            count += l.get(i);
            ans += count *  l.get(i + 1);
        }
        
        return ans;
    }
}