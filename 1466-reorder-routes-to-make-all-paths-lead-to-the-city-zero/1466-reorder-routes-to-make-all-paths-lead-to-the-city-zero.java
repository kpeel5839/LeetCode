class Solution {
    public int minReorder(int n, int[][] connections) {
        List<ArrayList<int[]>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < connections.length; i++) {
            graph.get(connections[i][1]).add(new int[] {connections[i][0], 0});
            graph.get(connections[i][0]).add(new int[] {connections[i][1], 1});
        }
        
        boolean[] v = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        v[0] = true;
        int ans = 0;
        
        while (!q.isEmpty()) {
            int p = q.poll();
            
            for (int[] next : graph.get(p)) {
                if (!v[next[0]]) {
                    q.add(next[0]);
                    v[next[0]] = true;
                    ans += next[1];
                }
            }
        }
        
        return ans;
    }
}