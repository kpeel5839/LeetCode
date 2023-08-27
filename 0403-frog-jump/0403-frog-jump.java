class Solution {
    public int n;
    public int[][] dp;
    public int[] stones;
    public int[] dx = {-1, 0, 1};
    public Map<Integer, Integer> m = new HashMap<>();
    public int dfs(int jump, int index) {
        if (index == n - 1) {
            return 1; 
        }

        if (dp[jump][index] != -1) {
            return dp[jump][index];
        }

        dp[jump][index] = 0;
        for (int j = 0; j < 3; j++) {
            int newValue = stones[index] + jump + dx[j];
            
            if (m.containsKey(newValue) && index < m.get(newValue)) {
                dp[jump][index] |= dfs(jump + dx[j], m.get(newValue));
            }
        }

        return dp[jump][index];
    }

    public boolean canCross(int[] stones) {
        this.n = stones.length;
        this.stones = stones;
        this.dp = new int[n + 1][n];
        for (int i = 0; i < n; i++) {
            m.put(stones[i], i);
        }
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        if (dfs(0, 0) == 1) {
            return true;
        }
        return false;
    }
}