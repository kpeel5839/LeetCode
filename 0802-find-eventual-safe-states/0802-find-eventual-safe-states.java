class Solution {
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> g = new ArrayList<>();
        int[] entry = new int[graph.length];
        
        for (int i = 0; i < graph.length; i++) {
            g.add(new ArrayList<>());
            entry[i] = graph[i].length;
        }
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
         
        for (int i = 0; i < graph.length; i++) {
            if (entry[i] == 0) {
                q.add(i);
            } 
            
            for (Integer next : graph[i]) {
                g.get(next).add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int v = q.poll();
            ans.add(v);
            
            for (Integer next : g.get(v)) {
                entry[next]--;
                
                if (entry[next] == 0) {
                    q.add(next);     
                }
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
}