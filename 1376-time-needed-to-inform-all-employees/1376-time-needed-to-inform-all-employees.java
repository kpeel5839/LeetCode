class Solution {

    public List<ArrayList<int[]>> graph = new ArrayList<>();
    public int ans = 0;

    public void dfs(int c, int value) {
        ans = Math.max(ans, value);

        for (int[] next : graph.get(c)) {
            dfs(next[0], value + next[1]);
        }
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                graph.get(manager[i]).add(new int[] {i, informTime[manager[i]]});
            }
        }
        
        dfs(headID, 0);
        return ans;
    }
}