class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k++;
        List<ArrayList<int[]>> graph = new ArrayList<>(); // {destination, price};       
        int[][] dist = new int[n][k + 1];
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < flights.length; i++) {
            graph.get(flights[i][0]).add(new int[] {flights[i][1], flights[i][2]});        
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]); // {point, number of stop, cost};
        queue.add(new int[] {src, 0, 0});    
        dist[src][0] = 0;
        
        while (!queue.isEmpty()) {
            int[] point = queue.poll();                    
            
            if (point[2] > dist[point[0]][point[1]]) {
                continue;
            }
            
            if (point[1] == k) {
                continue;
            }
            
            for (int[] next : graph.get(point[0])) {                        
                if (dist[next[0]][point[1] + 1] > point[2] + next[1]) {
                    queue.add(new int[] {next[0], point[1] + 1, point[2] + next[1]});
                    dist[next[0]][point[1] + 1] = point[2] + next[1];                
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i <= k; i++) {
            answer = Math.min(answer, dist[dst][i]);
        }
        
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        
        return answer;
    }
}