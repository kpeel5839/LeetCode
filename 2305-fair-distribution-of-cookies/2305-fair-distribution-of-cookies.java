class Solution {
    
    public int[] dis;
    public int ans;
    public int[] c;
    public int k;
    
    public void dfs(int index, int max) {
        if (index == c.length) {
            ans = Math.min(ans, max);
            return;
        } 
          
        for (int i = 0; i < k; i++) {
            dis[i] += c[index];
            dfs(index + 1, Math.max(max, dis[i]));
            dis[i] -= c[index];
        }
    }
    
    public int distributeCookies(int[] cookies, int k) {
        this.dis = new int[k];
        ans = Integer.MAX_VALUE;
        this.c = cookies;
        this.k = k;
        dfs(0, 0);
        return ans;
    }

}