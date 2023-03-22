class Solution {
    public int minScore(int n, int[][] roads) {
        List<ArrayList<int[]>> graph = new ArrayList<>();
        boolean[] v = new boolean[n];
        int ans = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < roads.length; i++) {
            graph.get(roads[i][0] - 1).add(new int[] {roads[i][1] - 1, roads[i][2]});
            graph.get(roads[i][1] - 1).add(new int[] {roads[i][0] - 1, roads[i][2]});
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while (!q.isEmpty()) {
            int p = q.poll();
            
            for (int[] next : graph.get(p)) {
                ans = Math.min(ans, next[1]);
                
                if (!v[next[0]]) {
                    v[next[0]] = true;
                    q.add(next[0]);
                }
            }
        }
        
        return ans;
    }
}