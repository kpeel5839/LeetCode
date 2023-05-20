class Solution {
    public Map<String, ArrayList<Object[]>> g;
    public Map<String, Double> v;
    public Map<String, String> p;
    
    public String find(String a) {
        if (p.get(a).equals(a)) {
            return a;
        }
        
        p.put(a, find(p.get(a)));
        return p.get(a);   
    }
    
    public void union(String a, String b) {
        p.put(b, a);
    }
    
    public void dfs(String c) {
        for (Object[] o : g.get(c)) {
            String nextNode = (String) o[0];
            double nextValue = (double) o[1];
            
            if (v.get(nextNode) == 0) {
                v.put(nextNode, v.get(c) * nextValue);
                dfs(nextNode);
            }
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {    
        g = new HashMap<>();
        v = new HashMap<>();
        p = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            v.put(a, 0d);
            v.put(b, 0d);
            p.put(a, a);
            p.put(b, b);
            
            if (!g.containsKey(a)) {
                g.put(a, new ArrayList<>());
            }
            
            if (!g.containsKey(b)) {
                g.put(b, new ArrayList<>());
            }
            
            g.get(a).add(new Object[] {b, 1 / values[i]});
            g.get(b).add(new Object[] {a, values[i]});
        }
        
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            
            a = find(a);
            b = find(b);
            
            if (!a.equals(b)) {
                union(a, b);
            }
        }
        
        for (Map.Entry<String, ArrayList<Object[]>> entry : g.entrySet()) {
            if (v.get(entry.getKey()) == 0) {
                v.put(entry.getKey(), 1d);
                dfs(entry.getKey());
            }
        }
        
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            
            if ((!p.containsKey(a) || !p.containsKey(b)) || !find(a).equals(find(b))) {
                ans[i] = -1;
            } else {
                ans[i] = v.get(a) / v.get(b);
            }
        }
        
        return ans; 
    }
}