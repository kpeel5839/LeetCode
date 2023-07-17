class Solution {

    public int[][] dp;
    public int[][] events;
    public int[] jump;
    public int k;

    public int dfs(int index, int count) {
        if (index == events.length || count == k) {
            return 0;    
        }

        if (dp[count][index] != -1) {
            return dp[count][index];
        }
        
        dp[count][index] = Math.max(dfs(jump[index], count + 1) + events[index][2], dfs(index + 1, count));

        return dp[count][index];
    }

    public int maxValue(int[][] events, int k) {
        this.events = events;
        this.k = k;
        this.jump = new int[events.length];
        dp = new int[k + 1][events.length];

        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], -1); 
        }
        
        Arrays.sort(events, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            
            return o1[0] - o2[0];
        });

        for (int i = 0; i < events.length; i++) {
            int l = i + 1;
            int r = events.length - 1;
            int des = events.length; 
            
            while (l <= r) {
                int m = (l + r) / 2;

                if (events[i][1] < events[m][0]) {
                    des = m;
                    r = m - 1;    
                } else {
                    l = m + 1;
                }
            }

            jump[i] = des;
        }

        return dfs(0, 0); 
    }
}