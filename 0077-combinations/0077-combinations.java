class Solution {
    
    public int n;
    public int k;
    public List<List<Integer>> ans = new ArrayList<>();
    
    public void dfs(List<Integer> list, int index) {
        if (list.size() == k) {
            ans.add(list);
        }
        
        if (index == n + 1) {
            return;      
        }
        
        for (int i = index; i <= n; i++) {
            List<Integer> copyList = new ArrayList<>(list);
            copyList.add(i);
            dfs(copyList, i + 1); 
        }
        
    }
    
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        dfs(new ArrayList<>(), 1);
        return ans;
    }
}