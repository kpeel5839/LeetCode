class Solution {
    public long answer = 0;
    public List<ArrayList<Integer>> graph = new ArrayList<>();
    
    public int dfs(int current, int parent, int seats) {
        int numberOfNodeUntilNow = 1;
        
        for (int next : graph.get(current)) {
            if (next != parent) {
                numberOfNodeUntilNow += dfs(next, current, seats);
            }
        }
        
        if (current != 0) {
            answer += Math.ceil((double) numberOfNodeUntilNow / (double) seats);   
        }    
        
        return numberOfNodeUntilNow;
    }
    
    public long minimumFuelCost(int[][] roads, int seats) {
        for (int i = 0; i < roads.length + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < roads.length; i++) {
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        
        dfs(0, -1, seats);
        return answer;
    }
}