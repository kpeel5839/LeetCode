class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        boolean[] c = new boolean[n];
        
        for (List<Integer> list : edges) {
            c[list.get(1)] = true;    
        }
        
        for (int i = 0; i < c.length; i++) {
            if (!c[i]) {
                ans.add(i);
            }    
        }
        
        return ans;
    }
}