class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> o1[0] - o2[0]);
        int n = pairs.length;
        int[] dp = new int[n];
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            int max = 0;

            for (int j = i - 1; 0 <= j; j--) {
                if (pairs[j][1] < pairs[i][0]) {
                    max = Math.max(max, dp[j]);
                }
            }

            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }
        
        return ans; 
    }
}