class Solution {
    public List<ArrayList<Integer>> graph = new ArrayList<>();
    public Map<Integer, int[]> m = new HashMap<>();
    public int[] except = new int[26];
    public boolean[] v;
    public String color = null;
    public boolean existCycle = false;
    
    public int[] dfs(int c) {
        if (m.containsKey(c)) {
            return m.get(c);
        }

        if (v[c]) {
            return except;
        }
        
        v[c] = true;
        int[] now = new int[26];
        
        for (Integer next : graph.get(c)) {                      
            int[] nextValue = dfs(next);            
            if (nextValue[0] != -1) { 
                for (int i = 0; i < 26; i++) {
                    now[i] = Math.max(now[i], nextValue[i]);
                }
            } else {
                existCycle = true;
            }
        }
        
        if (existCycle) {
            Arrays.fill(now, -1);
        } else {
            now[color.charAt(c) - 'a']++;
        }
        
        m.put(c, now);
        return now;
    }
    
    public int largestPathValue(String colors, int[][] edges) {
        color = colors;
        v = new boolean[colors.length()];
        Arrays.fill(except, -1);
        
        for (int i = 0; i < colors.length(); i++) {
            graph.add(new ArrayList<>());    
        }
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        
        int ans = -1;
        
        for (int i = 0; i < colors.length(); i++) {
            if (!v[i]) {            
                int[] vv = dfs(i);            
                
                for (int j = 0; j < vv.length; j++) {
                    ans = Math.max(ans, vv[j]);
                }
            }
        }
        
        return existCycle ? -1 : ans;
    }
}