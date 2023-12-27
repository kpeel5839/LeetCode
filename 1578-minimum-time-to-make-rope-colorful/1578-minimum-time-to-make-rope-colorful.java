class Solution {
    
    public String c;
    public List<Integer> t;
    public int[][] dp;
    public final int INF = 1_000_000_010;
    
    public int dfs(int pre, int index) {
        if (index == c.length()) {
            return 0;
        }
            
        if (dp[pre][index] != INF) {
            return dp[pre][index];
        }
        
        if (pre == 0) {
            int nextPre = (index == c.length() - 1) ? 0 : (c.charAt(index) == c.charAt(index + 1) ? 1 : 0);
            dp[pre][index] = Math.min(dfs(nextPre, index + 1), dfs(0, index + 1) + t.get(index));
        } 
        
        if (pre == 1) {
            dp[pre][index] = dfs(0, index + 1) + t.get(index);
        }
        
        return dp[pre][index];
    }
    
    public int minCost(String colors, int[] neededTime) {
        int answer = 0; 
        char pre = colors.charAt(0);
        int max = 0;
        int sum = 0;
        List<Integer> t = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < colors.length(); i++) { 
            char c = colors.charAt(i);
            
            if (pre != c) { 
                answer += (sum - max);
                t.add(max);
                sb.append(pre);
                sum = 0;
                max = 0;
                pre = c;
            } 
            
            sum += neededTime[i];
            max = Math.max(max, neededTime[i]);
        }
       
        answer += (sum - max);
        t.add(max);
        sb.append(pre);
        
        
        return answer;
    }
}