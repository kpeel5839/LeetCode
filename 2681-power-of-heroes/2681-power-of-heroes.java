class Solution {
    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        long MOD = 1_000_000_007;
        long[] dp = new long[nums.length + 1];
        long ans = 0;

        for (int i = nums.length - 1; 0 <= i; i--) {         
            long[] powpow = new long[4];
            powpow[0] = 1;

            for (int j = 1; j <= 3; j++) {
                powpow[j] = (powpow[j - 1] * nums[i]) % MOD;
            }   

            ans += (nums[i] * dp[i + 1] + powpow[3]) % MOD;            
            dp[i] = (dp[i + 1] * 2 + powpow[2]) % MOD;            
        }

        return (int) (ans % MOD);
    }
}