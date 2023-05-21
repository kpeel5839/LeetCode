class Solution {
    public int n;
    public List<ArrayList<int[]>> graph;
    
    public int[][] bfs(int s, boolean skipNegative) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);        
        int[] distance = new int[n];
        int[] parent = new int[n]; 
        int[] index = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[s] = 0;    
        q.add(new int[] {s, 0});
        
        while (!q.isEmpty()) {
            int[] point = q.poll();            
            
            if (distance[point[0]] < point[1]) {
                continue;
            }
            
            for (int[] next : graph.get(point[0])) {
                int cost = next[1];
                
                if (cost == -1) {
                    if (skipNegative) {
                        continue;
                    }

                    cost = 1;
                }
                
                if (point[1] + cost < distance[next[0]]) {
                    q.add(new int[] {next[0], point[1] + cost});
                    distance[next[0]] = point[1] + cost;
                    index[next[0]] = next[2];
                    parent[next[0]] = point[0];
                }
            }
        }

        int[][] arr = new int[][] {distance, index, parent};
        return arr;
    }
    
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        graph = new ArrayList<>();    
        this.n = n;    
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());             
        }
        
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int c = edges[i][2];
            
            graph.get(a).add(new int[] {b, c, i});
            graph.get(b).add(new int[] {a, c, i});
        }
        
        int[][] skip = bfs(destination, true);

        if (skip[0][source] < target) { // 가는 비용이 target 보다 적으면 못바꿈
            return new int[][] {};
        }

        int[][] noSkip = bfs(source, false);    

        if (target < noSkip[0][destination]) {
            return new int[][] {};
        }
        
        List<Integer> path = new ArrayList<>();
        path.add(destination);
        while (path.get(path.size() - 1) != source) {            
            path.add(noSkip[2][path.get(path.size() - 1)]);
        }

        Collections.reverse(path);

        int walked = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            int a = path.get(i); // 출발점
            int b = path.get(i + 1); // 도착점
            int c = noSkip[1][b]; // 내가 b 로 가기 위해 선택한 index
            
            if (edges[c][2] == -1) {
                edges[c][2] = Math.max(target - skip[0][b] - walked, 1);
            }

            walked += edges[c][2];
        }

        for (int i = 0; i < edges.length; i++) {
            if (edges[i][2] == -1) {
                edges[i][2] = 2 * (int) Math.pow(10, 9);
            }
        }
        
        return edges;
    }
}