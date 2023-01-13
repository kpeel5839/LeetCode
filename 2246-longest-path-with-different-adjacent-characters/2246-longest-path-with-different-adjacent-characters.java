class Solution {
    public String label;
    public List<ArrayList<Integer>> graph = new ArrayList<>();
    public int answer = 0;
    
    public int dfs(int[] parent, int previous, int current) {
        List<Integer> value = new ArrayList<>();
        
        for (Integer next : graph.get(current)) {
            if (previous != next) {
                value.add(dfs(parent, current, next));
            }
        }
        
        Collections.sort(value, (o1, o2) -> o2 - o1);
        int notSameNodeCount = 1;
        
        for (int i = 0; i < Math.min(value.size(), 2); i++) {
            notSameNodeCount += value.get(i);
        }
        
        answer = Math.max(answer, notSameNodeCount);
        notSameNodeCount = 1;
        
        if (value.size() != 0) {
            notSameNodeCount += value.get(0);
        }
        
        if (current != 0 && (label.charAt(parent[current]) == label.charAt(current))) {
            notSameNodeCount = 0;
        }
        
        return notSameNodeCount;
    }
    
    public int longestPath(int[] parent, String s) {    
        label = s;
        
        for (int i = 0; i < parent.length; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 1; i < parent.length; i++) {
            graph.get(i).add(parent[i]);
            graph.get(parent[i]).add(i);
        }
        
        dfs(parent, -1, 0);
        return answer;
    }
}