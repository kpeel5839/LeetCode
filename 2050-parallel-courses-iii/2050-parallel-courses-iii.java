class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] entry = new int[n + 1];
        int[] month = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < relations.length; i++) {
            graph.get(relations[i][0]).add(relations[i][1]);
            entry[relations[i][1]]++;
        }

        Queue<int[]> q = new LinkedList<>();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (entry[i] == 0) {
                q.add(new int[] {i, 0});
            }
        }

        while (!q.isEmpty()) {
            int[] p = q.poll();
            ans = Math.max(ans, p[1] + time[p[0] - 1]);
            
            for (Integer next : graph.get(p[0])) {
                month[next] = Math.max(month[next], p[1] + time[p[0] - 1]);

                if (--entry[next] == 0) {
                    q.add(new int[] {next, month[next]});
                }
            }
        }
        
        return ans;
    }
}