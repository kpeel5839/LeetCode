class Solution {
    public List<ArrayList<Integer>> graph = new ArrayList<>();
    public String label;
    public int[] answer;
    
    public int[] dfs(int parent, int current) {
        int[] frequency = new int['z' - 'a' + 1];
        frequency[label.charAt(current) - 'a']++;
        
        for (Integer next : graph.get(current)) {
            if (parent != next) {
                frequency = sumArrays(frequency, dfs(current, next));
            }
        }
        
        answer[current] = frequency[label.charAt(current) - 'a'];
        return frequency;
    }
    
    public int[] sumArrays(int[] firstArray, int[] secondArray) {
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] += secondArray[i];
        }
        
        return firstArray;
    }
    
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        answer = new int[n];
        label = labels;
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }        
        
        dfs(-1, 0);
        return answer;
    }
}