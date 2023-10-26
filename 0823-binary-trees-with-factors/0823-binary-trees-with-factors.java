class Solution {
    
    public int n;
    public int[] dp;
    public int[] arr;
    public Map<Integer, Integer> m = new HashMap<>();
    public static final int MOD = 1_000_000_007;

    public int dfs(int index) {
        if (dp[index] != -1) {
            return dp[index];
        }

        dp[index] = 1;

        for (int i = 0; i < n; i++) {
            if (arr[index] % arr[i] != 0 || !m.containsKey(arr[index] / arr[i])) {
                continue;
            }
            
            long result = ((long) dfs(i) * (long) dfs(m.get(arr[index] / arr[i]))) % MOD;
            dp[index] = (int) (((long) dp[index] + result) % MOD);
        }

        return dp[index] % MOD;
    }

    public int numFactoredBinaryTrees(int[] arr) {
        this.n = arr.length;
        this.arr = arr;
        dp = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = -1;
            m.put(arr[i], i);
        }
        
        for (int i = 0; i < n; i++) {
            ans = (ans + dfs(i)) % MOD;
        }

        return ans;
    }
}