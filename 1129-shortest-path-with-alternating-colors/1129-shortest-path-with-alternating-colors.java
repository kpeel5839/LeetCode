class Solution {   
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] distance = new int[n];
        boolean[][] visited = new boolean[2][n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        List<ArrayList<int[]>> graph = new ArrayList<>();
        final int RED = 0;
        final int BLUE = 1;
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < redEdges.length; i++) {
            graph.get(redEdges[i][0]).add(new int[] {redEdges[i][1], RED});
        }
        
        for (int i = 0; i < blueEdges.length; i++) {
            graph.get(blueEdges[i][0]).add(new int[] {blueEdges[i][1], BLUE});
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, -1}); // current, distance, edgeColor
        distance[0] = 0;
        
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            
            for (int[] next : graph.get(point[0])) {
                if (point[2] != next[1] && !visited[next[1]][next[0]]) {
                    distance[next[0]] = Math.min(distance[next[0]], point[1] + 1);
                    visited[next[1]][next[0]] = true;
                    queue.add(new int[] {next[0], point[1] + 1, next[1]});
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            } 
        }
        
        return distance;
    }
}