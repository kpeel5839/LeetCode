class Solution {
    public int[] parent;
    public List<ArrayList<int[]>> graph = new ArrayList<>();
    public Map<Integer, HashSet<Integer>> valueToIndex = new HashMap<>();
    
    public int find(int value) {
        if (parent[value] == value) {
            return value;
        }
        
        parent[value] = find(parent[value]);
        return parent[value];
    }
    
    public void union(int first, int second) {
        parent[find(first)] = find(second);
    }
    
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        parent = new int[vals.length];
        Set<Integer> duplicateRemover = new HashSet<>();
        
        for (int i = 0; i < vals.length; i++) {
            graph.add(new ArrayList<>());
            parent[i] = i;
            duplicateRemover.add(vals[i]);
            valueToIndex.put(vals[i], new HashSet<>());
        }
        
        List<Integer> values = new ArrayList<>(duplicateRemover);
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new int[] {edges[i][1], vals[edges[i][1]]});
            graph.get(edges[i][1]).add(new int[] {edges[i][0], vals[edges[i][0]]});
            
            valueToIndex.get(vals[edges[i][0]]).add(edges[i][0]);
            valueToIndex.get(vals[edges[i][1]]).add(edges[i][1]);
        }
        
        int result = vals.length;
        Collections.sort(values);
        
        for (int i = 0; i < values.size(); i++) {
            for (Integer node : valueToIndex.get(values.get(i))) {
                for (int[] nextNode : graph.get(node)) {
                    if (nextNode[1] <= values.get(i)) {
                        union(nextNode[0], node);
                    }
                }
            }
            
            Map<Integer, Integer> groupCount = new HashMap<>();
            for (Integer node : valueToIndex.get(values.get(i))) {
                groupCount.put(find(node), groupCount.getOrDefault(find(node), 0) + 1);
            }
            
            for (Integer value : groupCount.values()) {
                if (value != 1) {
                    result += (value * (value - 1)) / 2;
                }
            }
        }
        
        return result;
    }
}