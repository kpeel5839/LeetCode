class Solution {
    
    public Map<Integer, Set<Integer>> bts = new HashMap<>();
    public Map<Integer, List<Integer>> stb = new HashMap<>();
    public List<List<Integer>> graph = new ArrayList<>();
    
    public int bfs(int source, int target) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[bts.size()];
        
        for (Integer bus : stb.get(source)) {
            q.add(new int[] {bus, 1});
            visited[bus] = true;
        }
        
        while (!q.isEmpty()) {
            int[] p = q.poll();
            
            if (bts.get(p[0]).contains(target)) {
                return p[1];
            }
            
            for (Integer bus : graph.get(p[0])) {
                if (!visited[bus]) {
                    q.add(new int[] {bus, p[1] + 1});
                    visited[bus] = true;
                }
            }
        }
        
        return -1;
    }
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        for (int i = 0; i < routes.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < routes[i].length; j++) {
                set.add(routes[i][j]);
                
                if (!stb.containsKey(routes[i][j])) {
                    stb.put(routes[i][j], new ArrayList<>());
                }
                
                stb.get(routes[i][j]).add(i);
            }
            bts.put(i, set);
        }
        
        for (int i = 0; i < routes.length; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                for (Integer next : stb.get(routes[i][j])) {
                    if (next == i) {
                        continue;
                    }
                    
                    graph.get(i).add(next);
                }
            }
        }
        
        return bfs(source, target);
    }
}