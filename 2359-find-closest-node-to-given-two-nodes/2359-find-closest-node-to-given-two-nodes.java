class Solution {
    public List<ArrayList<Integer>> graph = new ArrayList<>();
    public int[][] distance;
    public boolean[] visited;
    
    public void dfs(int startNodeNumber, int distanceFromNow, int cur) {
        if (visited[cur]) {
            return;
        }
        
        visited[cur] = true;
        distance[startNodeNumber][cur] = distanceFromNow;
        
        for (Integer next : graph.get(cur)) {
            dfs(startNodeNumber, distanceFromNow + 1, next);
        }
    }
    
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        distance = new int[2][edges.length];
        for (int i = 0; i < edges.length; i++) {
            graph.add(new ArrayList<>());
            distance[0][i] = -1;
            distance[1][i] = -1;
        }    
        
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] != -1) {
                graph.get(i).add(edges[i]);
            }
        }
        
        visited = new boolean[edges.length];
        dfs(0, 0, node1);
        visited = new boolean[edges.length];
        dfs(1, 0, node2);
        
        int minDistance = Integer.MAX_VALUE;
        int answer = -1;
        
        for (int i = 0; i < edges.length; i++) {
            if (distance[0][i] != -1 && distance[1][i] != -1) {            
                if (minDistance > Math.max(distance[0][i], distance[1][i])) {
                    minDistance = Math.max(distance[0][i], distance[1][i]);
                    answer = i;
                }
            }
        }
        
        return answer;
    }
}