import java.util.*;

class Solution {
    public List<List<Integer>> result = new ArrayList<>();
    
    public void bruteForce(int current, int[][] graph, List<Integer> visitVertexUntilNow) {
        for (Integer next : graph[current]) {
            List<Integer> nextVisit = new ArrayList<>(visitVertexUntilNow);
            nextVisit.add(next);
            bruteForce(next, graph, nextVisit);
        }
        
        if (current == graph.length - 1) {
            result.add(visitVertexUntilNow);
        }
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> visitVertexUntilNow = new ArrayList<>();
        visitVertexUntilNow.add(0);
        bruteForce(0, graph, visitVertexUntilNow);
        return result;
    }
}