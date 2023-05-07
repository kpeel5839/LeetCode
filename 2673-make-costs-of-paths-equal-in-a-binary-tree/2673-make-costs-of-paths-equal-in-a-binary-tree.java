class Solution {
    public int limit;
    public long ans;
    
    public long dfs(int depth, int c, int[] cost) {
        if (depth == limit) {            
            return cost[c - 1];
        }
                
        long a = dfs(depth + 1, c * 2, cost);
        long b = dfs(depth + 1, c * 2 + 1, cost);
        
        ans += Math.max(a, b) - Math.min(a, b);
        return cost[c - 1] + Math.max(a, b);
    }
    
    public int minIncrements(int n, int[] cost) {
        limit = (int) Math.ceil(Math.log(n) / Math.log(2));
        ans = 0;
        
        dfs(1, 1, cost);
        return (int) ans;
    }
}