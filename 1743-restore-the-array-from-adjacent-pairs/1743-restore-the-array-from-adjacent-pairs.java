class Solution {
    
    public List<Integer> ans = new ArrayList<>();
    public Map<Integer, List<Integer>> graph = new HashMap<>();
    public Set<Integer> visited = new HashSet<>();
    
    public void dfs(int cur) {
        if (visited.contains(cur)) {
            return;
        }
        
        ans.add(cur);
        visited.add(cur);
        
        for (Integer next : graph.get(cur)) {
            dfs(next);
        }
    }
    
    public int[] restoreArray(int[][] pairs) {
        for (int i = 0; i < pairs.length; i++) { 
            if (!graph.containsKey(pairs[i][0])) {
                graph.put(pairs[i][0], new ArrayList<>());
            }
            
            if (!graph.containsKey(pairs[i][1])) {
                graph.put(pairs[i][1], new ArrayList<>());
            }

            graph.get(pairs[i][0]).add(pairs[i][1]);
            graph.get(pairs[i][1]).add(pairs[i][0]);
        }
        
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            List<Integer> next = entry.getValue();
            
            if (next.size() == 1) {
                dfs(entry.getKey());
                break;
            }
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}