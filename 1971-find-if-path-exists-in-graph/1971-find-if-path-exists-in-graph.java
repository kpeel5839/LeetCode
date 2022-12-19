import java.util.*;

class Solution {
    public boolean[] visited;
    
    public void dfs(List<ArrayList<Integer>> graph, int vertex) {
        if (visited[vertex]) {
            return;
        }
        
        visited[vertex] = true;
        
        for (Integer next : graph.get(vertex)) {
            dfs(graph, next);
        }
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<ArrayList<Integer>> graph = new ArrayList<>();
        visited = new boolean[n];    
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }    
        
        dfs(graph, source);
        return visited[destination];
    }
}