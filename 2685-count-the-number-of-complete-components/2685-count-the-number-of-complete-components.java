class Solution {
    public int[] p;
    
    public int find(int x) {
        if (p[x] == x) {
            return x;
        }
        
        return p[x] = find(p[x]);
    }
    
    public void union(int a, int b) {
        p[b] = a;
    }
    
    public int countCompleteComponents(int n, int[][] edges) {
        p = new int[n];
        int[] c = new int[n];
        
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        
        for (int i = 0; i < edges.length; i++) {
            c[edges[i][0]]++;
            c[edges[i][1]]++;
            
            int a = find(edges[i][0]);
            int b = find(edges[i][1]);
            
            if (a != b) {
                union(a, b);
            }
        }
            
        Map<Integer, Boolean> m = new HashMap<>();
        Map<Integer, Integer> mm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = find(i);
            mm.put(a, mm.getOrDefault(a, 0) + 1);
        }
        
        for (int i = 0; i < n; i++) {
            int a = find(i);
            
            if (!m.containsKey(a)) {
                m.put(a, true);
            }
            
            if (mm.get(a) - 1 != c[i]) {
                m.put(a, false);
            }            
        }
        
        int ans = 0;
        
        for (Boolean b : m.values()) {
            if (b) {
                ans++;
            }
        }
        
        return ans;
    }
}