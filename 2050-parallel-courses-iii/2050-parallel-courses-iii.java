
class Solution {
    private int[] startNodes;
    private int[][] graph;
    private int[] time;
    private boolean[] visited;
    private int[] ans;

    private void convert(final int[][] edges, final int n) {
        final int[] incoming = new int[n], outgoing = new int[n];
        for(final int[] e : edges) {
            outgoing[e[0] - 1]++;
            incoming[e[1] - 1]++;
        }
        int startCnt = 0;
        for(final int i : incoming) {
            if (i == 0) {
                startCnt++;
            }
        }
        startNodes = new int[startCnt];
        for(int sni = 0, i = 0; sni < startNodes.length; i++) {
            if (incoming[i] == 0) {
                startNodes[sni++] = i;
            }
        }
        graph = new int[n][];
        for(int i = 0; i < n; i++) {
            graph[i] = new int[outgoing[i]];
        }
        for(final int[] e : edges) {
            graph[e[0] - 1][--outgoing[e[0] - 1]] = e[1] - 1;
        }
    }

    private int fill(final int node) {
        if (ans[node] > 0) {
            return ans[node];
        }

        int worstPrereq = 0;
        visited[node] = true;
        for(final int child : graph[node]) {
            if (!visited[child]){
                worstPrereq = Math.max(fill(child), worstPrereq);
            }
        }
        visited[node] = false;
        return ans[node] = worstPrereq + time[node];
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        convert(relations, n);
        this.time = time;
        ans = new int[n];
        visited = new boolean[n];
        int longest = 0;
        for(final int node : startNodes) {
            longest = Math.max(longest, fill(node));
        }
        return longest;
    }
}
