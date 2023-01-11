class Solution {
    public List<ArrayList<Integer>> graph = new ArrayList<>();
    public Boolean[] isApple;
    
    public int dfs(int parent, int current) {
        int distanceSum = 0;
        
        for (Integer next : graph.get(current)) {
            if (parent != next) {
                distanceSum += dfs(current, next);        
            }
        }
        
        int add = 0;
        if (distanceSum != 0 || isApple[current]) {
            add = 2;
        }
        
        return distanceSum + add;
    }
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        isApple = hasApple.stream().toArray(Boolean[]::new);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        int answer = dfs(-1, 0);
        return answer != 0 ? answer - 2 : answer;
    }
}