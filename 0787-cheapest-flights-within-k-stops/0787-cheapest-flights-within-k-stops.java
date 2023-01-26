class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<ArrayList<int[]>> graph = new ArrayList<>(); // {destination, price};       
        int[][] visited = new int[2][n];
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            visited[0][i] = Integer.MAX_VALUE;
            visited[1][i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < flights.length; i++) {
            graph.get(flights[i][0]).add(new int[] {flights[i][1], flights[i][2]});        
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]); // {point, number of stop, cost};
        queue.add(new int[] {src, 0, 0});    
        visited[0][src] = 0;
        visited[1][src] = 0;
        
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            
            if (point[0] == dst) {
                point[1]--;
            }
            
            if (point[1] > k) {
                continue;
            }
            
            if (point[0] == dst) {
                return point[2];
            }
            
            for (int[] next : graph.get(point[0])) {                        
                if (visited[0][next[0]] <= point[1] + 1 && visited[1][next[0]] < point[2] + next[1]) {
                    continue;
                }
                
                queue.add(new int[] {next[0], point[1] + 1, point[2] + next[1]});            
                visited[0][next[0]] = point[1] + 1;
                visited[1][next[0]] = point[2] + next[1];            
            }
        }
        
        return -1;
    }
}