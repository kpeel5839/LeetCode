class Solution {
    
    public int[] e;
    public int[][] request;
    public int ans = 0;
    
    public void dfs(int index, int count) {
        if (index == request.length) {
            if (good()) {
                ans = Math.max(ans, count);
            }
            return;
        }
        
        e[request[index][0]]--;
        e[request[index][1]]++;
        dfs(index + 1, count + 1);
        e[request[index][0]]++;
        e[request[index][1]]--;
        dfs(index + 1, count);
    }
    
    public boolean good() {
        for (int i = 0; i < e.length; i++) {
            if (e[i] != 0) {
                return false;
            }
        } 
        
        return true;
    }
    
    public int maximumRequests(int n, int[][] requests) {
        e = new int[n];
        this.request = requests;
        dfs(0, 0);
        return ans; 
    }
}