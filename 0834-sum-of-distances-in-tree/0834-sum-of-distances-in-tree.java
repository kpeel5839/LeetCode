class Solution {
    public List<ArrayList<Integer>> graph = new ArrayList<>();
    public int[] count;
    public int[] result;
    
    public int dfsForCount(int current, int parent, int depth) {            
        for (Integer next : graph.get(current)) {
            if (parent != next) {
                result[current] += dfsForCount(next, current, depth + 1);
                count[current] += count[next];
            }
        }
        
        return result[current] + depth;
    }
    
    public void dfsForResult(int current, int parent) { 
        for (Integer next : graph.get(current)) {
            if (parent != next) {
                result[next] = result[current] - count[next] + (count.length - count[next]);
                dfsForResult(next, current);
            }
        }
    }
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        result = new int[n];
        count = new int[n];
        
        Arrays.fill(count, 1);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        result[0] = dfsForCount(0, -1, 0);
        dfsForResult(0, -1);
        return result;
    }
}