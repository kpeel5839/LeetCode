class Solution {

    public List<List<Integer>> graph = new ArrayList<>();
    public boolean[] visited;

    public void dfs(int current) {
        if (visited[current]) {
            return;
        }

        visited[current] = true;
        
        for (Integer next : graph.get(current)) {
            dfs(next);
        }
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> m = new HashMap<>();
        visited = new boolean[n];
        int edgeCount = 0;
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            set.add(i);
        }

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                set.remove(leftChild[i]);
                graph.get(i).add(leftChild[i]);
                edgeCount++;
            }

            if (rightChild[i] != -1) {
                set.remove(rightChild[i]);
                graph.get(i).add(rightChild[i]);
                edgeCount++;
            }
        }

        if (edgeCount != n - 1) {
            return false;
        }

        if (2 <= set.size()) {
            return false;
        }

        dfs(set.iterator().next());

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
}