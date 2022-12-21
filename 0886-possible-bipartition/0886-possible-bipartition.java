class Solution {
    public boolean isBipartition(List<ArrayList<Integer>> graph, boolean[] visited, boolean[] group, int current) {
        for (Integer next : graph.get(current)) {
            if (!visited[next]) {
                visited[next] = true;
                group[next] = !group[current];
                
                if (!isBipartition(graph, visited, group, next)) {
                    return false;
                }
            } else if (group[current] == group[next]) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean possibleBipartition(int n, int[][] dislikes) {        
        boolean[] visited = new boolean[n + 1];
        boolean[] group = new boolean[n + 1];
        List<ArrayList<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < dislikes.length; i++) {
            graph.get(dislikes[i][0]).add(dislikes[i][1]);
            graph.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                
                if (!isBipartition(graph, visited, group, i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}